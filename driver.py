import sys
import torch
import math
import numpy
from findNewCentroids import findNewCentroids
from DisplayGraph import DisplayGraph

training = torch.tensor([[2, 3], [10, 11], [1, 0], [11, 14], [14, 14], [4, 5], [6, 1], [10, 10], [3, 3], [1.0, 1.0], [7, 7], [5, 5], [0, 0], [8, 13], [5, 1], [9,2], [2, 0], [9, 9], [8, 5], [8, 6], [7, 6], [2, 1]])
#training = torch.tensor([[2, 3], [10, 11], [1, 0], [11, 14]])
centroids_list = torch.tensor([[9.0, 7.0], [3.0, 5.0]])
num_of_centroids = len(centroids_list)

DisplayGraph(training, centroids_list)
f = 0
k = input("Enter how many iterations of a K-means Algorithm you would like to perform: ")

while f < int(k):
    new_centroids = findNewCentroids(training, centroids_list, num_of_centroids)

    DisplayGraph(training, new_centroids)

    f = f + 1