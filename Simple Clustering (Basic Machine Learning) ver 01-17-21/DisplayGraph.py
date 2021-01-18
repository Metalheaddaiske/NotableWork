import sys
import torch
import math
import numpy
from matplotlib import pyplot
from matplotlib import axes
from NearestCentroid import NearestCentroid

def DisplayGraph(data, centroid_list):

    i = 0
    Xvals = numpy.array(data.numpy()[i][0])
    Yvals = numpy.array(data.numpy()[i][1])
    i = 1

    while i < len(data):

        Xgrabbed = data.numpy()[i][0]
        Ygrabbed = data.numpy()[i][1]


        Xvals = numpy.append(Xvals, Xgrabbed)
        Yvals = numpy.append(Yvals, Ygrabbed)

        i = i + 1


    pyplot.figure()
    pyplot.subplot(131)
    pyplot.scatter(Xvals, Yvals)
    pyplot.xlim([-5, 15])
    pyplot.ylim([-5, 15])
    pyplot.title("Data Graph")

    Xcent = numpy.empty(0)
    Ycent = numpy.empty(0)

    j = 0
    while j < len(centroid_list):

        Xcent = numpy.append(Xcent, centroid_list.numpy()[j][0])
        Ycent = numpy.append(Ycent, centroid_list.numpy()[j][1])
        j = j + 1



    pyplot.subplot(132)
    pyplot.scatter(Xvals, Yvals, label = "Training Set")
    pyplot.scatter(Xcent, Ycent, label = "Centroids")
    pyplot.xlim([-5, 15])
    pyplot.ylim([-5, 15])
    pyplot.title("Data with Centroids")
    pyplot.legend()

    classifications = NearestCentroid(data, centroid_list, len(centroid_list))


    clusterXs = numpy.empty(0)
    clusterYs = numpy.empty(0)

    pyplot.subplot(133)

    t = 0
    while t < len(centroid_list):
        k = 0
        while k < len(data):

            z = int(classifications.numpy()[k][0])

            if z == t:
                clusterXs = numpy.append(clusterXs, data.numpy()[k][0])
                clusterYs = numpy.append(clusterYs, data.numpy()[k][1])

        #equiv = torch.eq(curr_centroid, the_centroids[z])

        #if equiv[0] and equiv[1]:
         #   Xavg += the_training_set.numpy()[i][0]
          #  Yavg += the_training_set.numpy()[i][1]
           # j = j + 1

            k = k + 1

        pyplot.scatter(clusterXs, clusterYs, label="Cluster" + str(t))
        clusterXs = numpy.empty(0)
        clusterYs = numpy.empty(0)
        t = t + 1



    pyplot.xlim([-5, 15])
    pyplot.ylim([-5, 15])
    pyplot.title("Clustered Data")
    pyplot.legend()

    pyplot.tight_layout()
    pyplot.show()