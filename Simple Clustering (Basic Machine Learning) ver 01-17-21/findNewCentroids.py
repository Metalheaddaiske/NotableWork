import sys
import torch
import math
import numpy
from NearestCentroid import NearestCentroid

def findNewCentroids(training, centroids_list, num_of_centroids):

    the_training_set = training
    the_centroids = centroids_list
    num_centroids = num_of_centroids

    classifications = NearestCentroid(the_training_set, the_centroids, num_centroids)


    i = 0
    j = 0
    f = 0

    new_centroids = the_centroids
    Xavg = 0
    Yavg = 0
    curr_centroid = the_centroids[i]

    while f < num_centroids:
        i = 0
        while i < len(the_training_set):

            z = int(classifications.numpy()[i][0])

            equiv = torch.eq(curr_centroid, the_centroids[z])

            if equiv[0] and equiv[1]:

                Xavg += the_training_set.numpy()[i][0]
                Yavg += the_training_set.numpy()[i][1]
                j = j + 1

            i = i + 1

        if j != 0:
            Xavg = Xavg / j
            Yavg = Yavg / j
            j = 0

        new_centroids.numpy()[f][0] = Xavg
        new_centroids.numpy()[f][1] = Yavg

        Xavg = 0
        Yavg = 0

        if f + 1 < num_centroids:
            f = f + 1
            curr_centroid = the_centroids[f]
        else:
            break


    print(new_centroids)
    return new_centroids