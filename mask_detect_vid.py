#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Thu Jun 11 11:41:57 2020
"""
import cv2
import numpy as np
from tensorflow.keras.models import load_model
from tensorflow.keras.preprocessing.image import img_to_array
from tensorflow.keras.applications.mobilenet_v2 import preprocess_input
import time
import os
import pyrebase

#Config from firebase
Config = {
    'apiKey': "AIzaSyA-G6PYaFwtORq-fm3KG2M0tvLytH7QR80",
    'authDomain': "maskdetector-547a8.firebaseapp.com",
    'databaseURL': "https://maskdetector-547a8.firebaseio.com",
    'projectId': "maskdetector-547a8",
    'storageBucket': "maskdetector-547a8.appspot.com",
    'messagingSenderId': "996994080435",
    'appId': "1:996994080435:web:2402e1c0972bb629a61ac6"
  };

#firebase iinitialize and datase calling
firebase = pyrebase.initialize_app(Config)
db = firebase.database()
 

def DetectVideo(vidpath):
    count = 0
    #frames used for analysis
    frame = [0,300,600,1200]
    print("[INFO] loading face detector model...")
    prototxtPath = os.path.join("C:/Users/abc/Desktop/covid19_face_mask_detection/face_detector/deploy.prototxt")
    weightsPath = os.path.join("C:/Users/abc/Desktop/covid19_face_mask_detection/face_detector/res10_300x300_ssd_iter_140000.caffemodel")
    faceNet = cv2.dnn.readNet(prototxtPath, weightsPath)

    print("[INFO] loading face mask detector model...")
    model = load_model('C:/Users/abc/Desktop/covid19_face_mask_detection/mask_model')
    #print(model.summary())
    
    # loop over the frames from the video stream
    while True:
        video_capture = cv2.VideoCapture(vidpath)
        success = True
        fps = int(video_capture.get(cv2.CAP_PROP_FPS))        
        time.sleep(2.0)
        #ret, frame = video_capture.read()
        #Getting frames after specific interval of time
        while success and count <= 1200:
            success,image = video_capture.read()
            print('read a new frame:',success)
            if count%(10*(fps)) == 0:
                cv2.imwrite('frames%d.jpg'%count,image)
                #frame = imutils.resize(frame, width=1000)
            count+=1
        #Looping over the frames captured 
        for i in frame:
            image = cv2.imread('frames%d.jpg'%i)
            #Count of people without mask
            no_count = 0
            #Count of people with mask
            m_count = 0
        #frame = imutils.resize(frame, width=1000)
        #frame = cv2.imread(imgpath)
        # grab the dimensions of the frame and then construct a blob
        # from it
            (h, w) = image.shape[:2]
            blob = cv2.dnn.blobFromImage(image, 1.0, (300, 300),(104.0, 177.0, 123.0))

        # pass the blob through the network and obtain the face detections
            faceNet.setInput(blob)
            detections = faceNet.forward()
        
        # loop over the detections
            for i in range(0, detections.shape[2]):
                # extract the confidence (i.e., probability) associated with
                # the detection
                confidence = detections[0, 0, i, 2]

            # filter out weak detections by ensuring the confidence is
            # greater than the minimum confidence
                if confidence < 0.5:
                    pass
                elif confidence >0.5:
                    # compute the (x, y)-coordinates of the bounding box for
                    # the object
                    box = detections[0, 0, i, 3:7] * np.array([w, h, w, h])
                    (x1,y1,x2,y2) = box.astype("int")
                    #define face 
                    face = image[y1:y2,x1:x2]
                    #print(face.shape)
                    face = cv2.resize(face, (224, 224))
                    face = img_to_array(face)/255.
                    face = preprocess_input(face)
                    face = np.expand_dims(face, axis=0)
                    pred = model.predict(face)
                    #print(pred)
                    for z in pred:
                        mask,without_mask = z
                        if mask > without_mask:
                            label = "Mask"
                            m_count+=1
                        else:
                            label="No Mask"
                            no_count+=1
                        color = (0, 255, 0) if label == "Mask" else (0, 0, 255)
                        label = "{}: {:.2f}%".format(label, max(mask, without_mask) * 100)
                        # include the probability in the label
                        cv2.putText(image, label, (x1, y1 - 10),cv2.FONT_HERSHEY_SIMPLEX, 0.45, color, 2)
                        cv2.rectangle(image, (x1, y1), (x2, y2), color, 2)  
                        print(label)
            
            #Push data on firebase to get updarted on app in realtime
            db.child('Cameras').child('Cam 1').push({'Latitude':'77.5011E','Longitude':'27.2038N','Place':'Mandi','no_mask': str(no_count),'mask':str(m_count)})
            cv2.imshow("Frame", image)
            key = cv2.waitKey(1) & 0xFF

            # if the `q` key was pressed, break from the loop
            if key == ord("q"):
                break

    # do a bit of cleanup
        video_capture.release()
        cv2.destroyAllWindows()
        return m_count, no_count


print("[INFO] loading video stream...")
DetectVideo(0)
