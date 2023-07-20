# Import necessary libraries 
import sys 
import numpy as np
import pandas as pd

#Getting the data 
data = pd.read_csv("happy_hounds_data.csv")

#Visualizing the dataset
data.head()

#Splitting the dataset into features and labels
X = data.iloc[:, :-1].values 
y = data.iloc[:, -1].values

#Splitting the dataset into training and test sets
from sklearn.model_selection import train_test_split
X_train, X_test, y_train, y_test = train_test_split(X, y, test_size = 0.2, random_state = 0)

#Feature Scaling
from sklearn.preprocessing import StandardScaler
sc = StandardScaler()
X_train = sc.fit_transform (X_train)
X_test = sc.transform(X_test)

#Training the Machine Learning model - SVM
from sklearn.svm import SVC
classifier_svm = SVC(kernel = 'linear', random_state = 0)
classifier_svm.fit(X_train, y_train)

#Making Predictions
y_pred = classifier_svm.predict(X_test)

#Evaluating the model
from sklearn.metrics import confusion_matrix, accuracy_score
cm = confusion_matrix(y_test, y_pred)
accuracy = accuracy_score(y_test, y_pred)

#Printing accuracy score
print("Accuracy score is: ", accuracy)

#Exporting the model
from joblib import dump, load
dump(classifier_svm, 'happy_hounds_svm.joblib')

#Predicting a single example
new_example = sc.transform([[1, 0, 0, 0, 0, 0, 0, 0, 0, 0]])
prediction = classifier_svm.predict(new_example)
print("Prediction for new example is: ", prediction)