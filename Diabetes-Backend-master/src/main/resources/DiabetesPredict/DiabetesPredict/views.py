from django.shortcuts import render


def index(request):
    return render(request, 'index.html')
def predict(request):
    return render(request, 'model.html')

from django.http import JsonResponse
from django.shortcuts import render
import pandas as pd
import numpy as np
from sklearn.preprocessing import StandardScaler
from sklearn.model_selection import train_test_split
from sklearn.linear_model import LogisticRegression
from sklearn import svm #uses support vector machine classifier to evaluate the model
from sklearn.metrics import accuracy_score

def index(request):
    return render(request, 'index.html')
def predict(request):
    return render(request, 'model.html')
def result(request):
    data = pd.read_csv(r"C:\Users\krish\OneDrive\Desktop\DiabetesPredict\DiabetesPredict\static\csv\diabetes.csv") #importing data
    X = data.drop(columns = 'Outcome', axis=1)#stores data without the outcome column
    Y = data['Outcome']#stores the outcome part of the dataset
    X_train, X_test, Y_train, Y_test = train_test_split(X,Y, test_size = 0.2, stratify=Y, random_state=2)

    classifier = LogisticRegression()
    classifier.fit(X_train, Y_train)
    X_test_pred = classifier.predict(X_test)
    test_accuracy = accuracy_score(X_test_pred, Y_test)
    test_accuracy = test_accuracy*100


    val1 = float(request.GET['Pregnancies'])
    val2 = float(request.GET['Glucose'])
    val3 = float(request.GET['Blood_Pressure'])
    val4 = float(request.GET['Skin_Thickness'])
    val5 = float(request.GET['Insulin'])
    val6 = float(request.GET['BMI'])
    val7 = float(request.GET['Pedigree'])
    val8 = float(request.GET['Age'])

    pred = classifier.predict([[val1, val2, val3, val4, val5, val6, val7, val8]])

    result1 = ""
    if pred ==[1]:
        result1 = "POSITIVE"
    else:
        result1 = "NEGATIVE"

    responseData = {
        'Pregnancies' : val1,
        'Glucose' : val2,
        'Blood_Pressure' : val3,
        'Skin_Thickness' : val4,
        'Insulin' : val5,
        'BMI' : val6,
        'Pedigree' : val7,
        'Age' : val8,
        'AccuracyScore' : test_accuracy,
        'Result' : result1
    }

    return JsonResponse(responseData)
def heart(request):
    data = pd.read_csv(r"C:\Users\krish\OneDrive\Desktop\Diabetes-Backend-master\Diabetes-Backend-master\src\main\resources\DiabetesPredict\static\csv\heart.csv") #importing data
    X = data.drop(columns = 'target', axis=1)#stores data without the outcome column
    Y = data['target']#stores the outcome part of the dataset
    X_train, X_test, Y_train, Y_test = train_test_split(X,Y, test_size = 0.2, stratify=Y, random_state=2)

    classifier = LogisticRegression()
    classifier.fit(X_train, Y_train)

    val1 = float(request.GET['Age'])
    val2 = float(request.GET['Sex'])
    val3 = float(request.GET['CP'])
    val4 = float(request.GET['Rest_Blood_Pressure'])
    val5 = float(request.GET['Cholestrol'])
    val6 = float(request.GET['Fasting_Blood_Sugar'])
    val7 = float(request.GET['Rest_ECG'])
    val8 = float(request.GET['Thalach'])
    val9 = float(request.GET['Exang'])
    val10 = float(request.GET['OldPeak'])
    val11 = float(request.GET['Slope'])
    val12 = float(request.GET['CA'])
    val13 = float(request.GET['Thal'])



    pred = classifier.predict([[val1, val2, val3, val4, val5, val6, val7, val8, val9, val10, val11, val12, val13]])
    X_test_pred = classifier.predict(X_test)
    test_accuracy = accuracy_score(X_test_pred, Y_test)
    test_accuracy = test_accuracy*100
    result1 = ""
    if pred ==[1]:
        result1 = "Defective Heart"
    else:
        result1 = "Healthy Heart"

    responseData2 = {
        'Age' : val1,
        'Sex' : val2,
        'CP' : val3,
        'RBP' : val4,
        'Cholestrol' : val5,
        'FBS' : val6,
        'RestECG' : val7,
        'Thalach' : val8,
        'Exang' : val9,
        'OldPeak' : val10,
        'Slope' : val11,
        'CA' : val12,
        'Thal' : val13,
        'Test_Accuracy' : test_accuracy,
        'Result' : result1
    }
    return JsonResponse(responseData2)