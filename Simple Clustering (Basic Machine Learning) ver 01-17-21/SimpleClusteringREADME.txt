Steven Woolf
Simple Clustering Program
Spring 2021

This project uses a K-means algorithm to categorize data into two clusters. All data items
are simply points on a cartesian coordinate system that do not intrinsically have any kind of meaning.
Eventually, I would like to use this project to analyze relationships in the occurence of certain words in wikipedia
articles. However, time has not permitted me to do this yet. Thus, instead, I hardcoded 22 data coordinates
and two initial centroids into the program.

USE:
-----------------------------------------------------------------------------------------------------------------------------------
To start the program, set the IDE or terminal to run "driver.py". This is the main driver class.

When you start the program, a graph of the data and current centroids will be displayed, along with the current clusters.
Close out this window. You will then be prompted by the console to input how many times you would like to run
the K-means algorithm. More iterations should result in centroids being closer to the "center" of their respective regions
in data, and thus produce more accurate clusters. However, once the centroids have reached the optimal position, you will
not see a change in the position of centroids with further iterations of the K-means algorithm.

TECHNOLOGY:
------------------------------------------------------------------------------------------------------------------------------------
This project employs the Matplotlib and Pytorch libraries.