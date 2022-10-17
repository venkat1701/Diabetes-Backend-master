# -*- coding: utf-8 -*-
"""Diabetes Prediction.ipynb

Automatically generated by Colaboratory.

Original file is located at
    https://colab.research.google.com/drive/14GvmlZjZqSzsJuhCHYwKuUwtNQQPgFWx

Importing Libraries
"""

import pandas as pd
import numpy as np
from sklearn.preprocessing import StandardScaler
from sklearn.model_selection import train_test_split
from sklearn import svm  # uses support vector machine classifier to evaluate the model
from sklearn.metrics import accuracy_score

data = pd.read_csv("C:\\Users\\krish\\OneDrive\\Desktop\\Diabetes-Backend-master\\Diabetes-Backend-master\\src\\main\\resources\\static\\csv\\diabetes.csv")  # importing data

data.shape  # reads the number of rows and columns

# checks if any null value is present
data.isnull().values.any()

data.head()  # previews data

# getting the statistical measures of the data
data.describe()

"""Plotting of heat map of datasets """

# Correlation
import seaborn as sns
import matplotlib.pyplot as plt

# get correlations of each features in dataset
corrmat = data.corr()
top_corr_features = corrmat.index
plt.figure(figsize=(12, 10))
# plot heat map
g = sns.heatmap(data[top_corr_features].corr(), annot=True, cmap="RdYlGn")

data['Outcome'].value_counts()  # displays the true and false count of diabetes - approx ratio 1:2

data.groupby('Outcome').mean()  # mean of outcome values

"""0 --> Non-Diabetic

1 --> Diabetic
"""

# To separating the data and labels
X = data.drop(columns='Outcome', axis=1)  # stores data without the outcome column
Y = data['Outcome']  # stores the outcome part of the dataset

print(X)

print(Y)

"""Data Standardization - standardizes data in a particular range which ML model to predict accurately 

"""

scaler = StandardScaler()

scaler.fit(X)  # stores the dataset stored in X

s_data = scaler.transform(X)  # stores the standarized data in s_data

print(s_data)  # prints standarized data in a particular range of 0s and 1s

X = s_data  # stores standarized data in X
Y = data['Outcome']  # stores the outcome part of the dataset

print(X)
print(Y)

"""Train Test Split"""

X_train, X_test, Y_train, Y_test = train_test_split(X, Y, test_size=0.2, stratify=Y, random_state=2)
# stores the training and testing dataset of X and Y respectively
# test size 0.2 denotes 20% of data being used for testing. The rest is used for training
# stratify enables the dataset to be of same proportionality b/w X and Y
# random state splits the data into 2

print(X.shape, X_train.shape, X_test.shape)  # shows 20% of data is used for testing and the rest 80% for training

"""Training the Model"""

classifier = svm.SVC(kernel='linear')  # SVC - suport vector classifier
# uses kernel linear regression model to evaluate

# training the Support Vector Machine Classifier
classifier.fit(X_train, Y_train)

"""Model Evaluation - To check how many times model is predicting correctly

Accuracy Score
"""


class diabetes:
    # accuracy score on the training data
    def __init__(self, train_accuracy=0):
        self._train_accuracy = train_accuracy
        # using the getter method   

    def get_train_accuracy(self):
        return self._train_accuracy
        # using the setter method

    def set_train_accuracy(self, x):
        self._train_accuracy = x

        # accuracy score on the test data

    def __init__(self, test_accuracy=0):
        self._test_accuracy = test_accuracy
        # using the getter method   

    def get_test_accuracy(self):
        return self._test_accuracy
        # using the setter method

    def set_test_accuracy(self, x):
        self._test_accuracy = x

        # predictive system

    def __init__(self, pred=0):
        self._pred = pred
        # using the getter method   

    def get_pred(self):
        return self._pred

    # using the setter method
    def set_pred(self, x):
        self._pred = x


obj = diabetes()
# accuracy score on the training data
X_train_pred = classifier.predict(X_train)
train_accuracy = accuracy_score(X_train_pred, Y_train)

obj.set_train_accuracy(train_accuracy)

print('Accuracy score of the training data: ',
      obj.get_train_accuracy())  ##Out of 100 times model is predicting the training data correctly 78 times
print((obj.get_train_accuracy() * 100), '%')

# accuracy score on the test data
X_test_pred = classifier.predict(X_test)
test_accuracy = accuracy_score(X_test_pred, Y_test)

obj.set_test_accuracy(test_accuracy)

print('Accuracy score of the test data: ',
      obj.get_test_accuracy())  ##Out of 100 times model is predicting the test data correctly 77 times
print((obj.get_test_accuracy() * 100), '%')

# Predictive System

input_data = (6, 102, 72, 35, 0, 33.6, 0.627, 50)  # sample data to be checked
numpy_arr = np.asarray(input_data)  # changing tHe input_data to numpy array
reshaped = numpy_arr.reshape(1, -1)  # reshaping the array as we are predicting for one instance
std_data = scaler.transform(reshaped)  # standardizing the input data
print(std_data)

pred = classifier.predict(std_data)  # predicting on the basis of std_data

obj.set_pred(pred)

print(obj.get_pred())
if (obj.get_pred()[0] == 0):
    print('NOT DIABETIC')
else:
    print('DIABETIC')
