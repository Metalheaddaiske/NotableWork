import sys
import torch
import math
import numpy
#This program calculates the closest centroids for a given training set,
#centroids, and number of centroids (usually called K)

def NearestCentroid(training_set, all_centroids, num_centroids):
    K = num_centroids
    X = training_set
    centroids = all_centroids

    curr_centroid = torch.zeros(len(X), 1)

    x = 0
    c = 0


    while x < len(X):

        closest = torch.tensor([centroids.numpy()[c][0], centroids.numpy()[c][1]])
        diff1 = X.numpy()[x][0] - closest.numpy()[0]
        diff2 = X.numpy()[x][1] - closest.numpy()[1]

        #calculate distance between "closest" and the current training example
        d = math.sqrt((diff1)**2 + (diff2)**2)
        d = d**2
        i = 0
        while i < K:

            prev_closest = closest
            prev_diff1 = diff1
            prev_diff2 = diff2
            prev_d = d

            next_c = i
            next_closest = torch.tensor([centroids.numpy()[next_c][0], centroids.numpy()[next_c][1]])

            next_diff1 = X.numpy()[x][0] - next_closest.numpy()[0]
            next_diff2 = X.numpy()[x][1] - next_closest.numpy()[1]

            next_d = math.sqrt((next_diff1)**2 + (next_diff2)**2)

            if next_d < d:
                closest = next_closest
                c = next_c
                diff1 = next_diff1
                diff2 = next_diff2
                d = next_d


            curr_centroid.numpy()[x] = c

            i = i + 1


        x = x + 1

    return curr_centroid