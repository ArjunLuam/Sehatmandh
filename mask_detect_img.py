#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Thu Jun 11 20:08:32 2020

@author: harit
"""

import cv2
import numpy as np
from keras.models import load_model
from keras.preprocessing.image import img_to_array
import os
import matplotlib.pyplot as plt
from tensorflow.keras.applications.mobilenet_v2 import preprocess_input


def DetectImage(imgpath):
    print("[INFO] loading face detector model...")
    prototxtPath = os.path.join("face_detector/deploy.prototxt")
    weightsPath = os.path.join("face_detector/res10_300x300_ssd_iter_140000.caffemodel")
    faceNet = cv2.dnn.readNet(prototxtPath, weightsPath)

    print("[INFO] loading face mask detector model...")
    model = load_model('mask_model')
    #print(model.summary())
    
    frame = cv2.imread(imgpath)
    (h, w) = frame.shape[:2]
    blob = cv2.dnn.blobFromImage(frame, 1.0, (300, 300),
        (104.0, 177.0, 123.0))

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
            face = frame[y1:y2,x1:x2]
            #print(face.shape)
            face = cv2.resize(face, (224, 224))
            face = img_to_array(face)/255.
            face = preprocess_input(face)
            face = np.expand_dims(face, axis=0)
            pred = model.predict(face)
            #print(pred)
            for z in pred:
                mask,without_mask = z
            label = "Mask" if mask > without_mask else "No Mask"
            color = (0, 255, 0) if label == "Mask" else (0, 0, 255)
            label = "{}: {:.2f}%".format(label, max(mask, without_mask) * 100)
            # include the probability in the label
            cv2.putText(frame, label, (x1, y1 - 10),cv2.FONT_HERSHEY_SIMPLEX, 0.45, color, 2)
            cv2.rectangle(frame, (x1, y1), (x2, y2), color, 2)  
            print(label)
    while True:
        cv2.imshow("Frame", frame)
        key = cv2.waitKey(1) & 0xFF
         #if the `q` key was pressed, break from the loop
        if key == ord("q"):
            break

    # do a bit of cleanup
    cv2.destroyAllWindows()


print("[INFO] loading Processed Image...")

DetectImage('/Users/harit/Documents/spyder/mask_detection/group.jpeg')

