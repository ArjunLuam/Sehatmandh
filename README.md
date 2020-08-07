# Machine Learning Detector
We are trying to build a Machine learning Detector that detects a person is wearing mask or not. Mask help to stop spreding of corona or any viral disease from air.
Our model works in real time and can be used at high density public place. it can measure safety level by counting no. of wearing mask and not wearing mask persons.
<br/>


## Model Approach
Our approach is to design a model using Transfer learning and opencv to detect masks or without masks. In our approach we used Mobilenetv2 as transfer learning. and train our model on Mobilenetv2. and we obtain approx 94.% accuracy sucessfully.

## Training and Validation Graph - 
<p align="center">
    <img src="https://github.com/ArjunLuam/Sehatmandh/blob/ml-detector/plot.png" alt="Image"  />
</p>
<br/>

## Sample Input - 
<p align="center">
  <img src="https://github.com/ArjunLuam/Sehatmandh/blob/ml-detector/Images/sample/23.jpg" width=270 height=300 />
  <img src="https://github.com/ArjunLuam/Sehatmandh/blob/ml-detector/Images/sample/266.jpeg" width=270 height=300 />
  <img src="https://github.com/ArjunLuam/Sehatmandh/blob/ml-detector/Images/sample/302.jpeg" width=270 height=300 />
  <img src="https://github.com/ArjunLuam/Sehatmandh/blob/ml-detector/Images/sample/491.jpeg" width=270 height=300 />
  <img src="https://github.com/ArjunLuam/Sehatmandh/blob/ml-detector/Images/sample/496.jpeg" width=270 height=300 />
  <img src="https://github.com/ArjunLuam/Sehatmandh/blob/ml-detector/Images/sample/538.jpeg" width=270 height=300 />
  <img src="https://github.com/ArjunLuam/Sehatmandh/blob/ml-detector/Images/sample/590.jpeg" width=270 height=300 />
  <img src="https://github.com/ArjunLuam/Sehatmandh/blob/ml-detector/Images/sample/615.jpeg" width=270 height=300 />
</p>
<br/>

## Sample Output - 
<p align="center">
  <img src="https://github.com/ArjunLuam/Sehatmandh/blob/ml-detector/Images/sample-output/23.jpg" width=270 height=300 />
  <img src="https://github.com/ArjunLuam/Sehatmandh/blob/ml-detector/Images/sample-output/266.jpeg" width=270 height=300 />
  <img src="https://github.com/ArjunLuam/Sehatmandh/blob/ml-detector/Images/sample-output/302.jpeg" width=270 height=300 />
  <img src="https://github.com/ArjunLuam/Sehatmandh/blob/ml-detector/Images/sample-output/491.jpeg" width=270 height=300 />
  <img src="https://github.com/ArjunLuam/Sehatmandh/blob/ml-detector/Images/sample-output/496.jpeg" width=270 height=300 />
  <img src="https://github.com/ArjunLuam/Sehatmandh/blob/ml-detector/Images/sample-output/538.jpeg" width=270 height=300 />
  <img src="https://github.com/ArjunLuam/Sehatmandh/blob/ml-detector/Images/sample-output/590.jpeg" width=270 height=300 />
  <img src="https://github.com/ArjunLuam/Sehatmandh/blob/ml-detector/Images/sample-output/615.jpeg" width=270 height=300 />
</p>
<br/>

## Files Description - 
### google_collab_training.ipynb 
> This file contain mask detector training with CNN and Transfer learning on google collab. <br/>
<p align="center">
  https://github.com/ArjunLuam/Sehatmandh/blob/ml-detector/google_collab_train.ipynb
 </p>

### mask_detection_train.py
> This file contain mask detector training on spyder and this file is a another version of google_collab_training.ipynb. <br/>
<p align="center">
  https://github.com/ArjunLuam/Sehatmandh/blob/ml-detector/mask_detection_train.py
 </p>
 
### mask_model
> This is weight applied architecture used for future predictions. <br/>
<p align="center">
  https://github.com/ArjunLuam/Sehatmandh/blob/ml-detector/mask_model
</p>

### mask_detect_img.py
> This file is used for real time mask detection on a single image. <br/>
<p align="center">
  https://github.com/ArjunLuam/Sehatmandh/blob/ml-detector/mask_detect_img.py
</p>

### mask_detect_vid.py
> This file is used for real time mask detection on webcam or any other camera. <br/>
<p align="center">
  https://github.com/ArjunLuam/Sehatmandh/blob/ml-detector/mask_detect_vid.py
</p>


# Contributors
> Arjun Anand <br/>
> Harit Yadav <br/>
> Reetvik Chatterjee <br/>
> Shivam Kumar
