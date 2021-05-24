# REMAHT
This repository contains the code that implements a methodology for reverse engineering android mobile applications developed in the context of a final dissertation of the Master in Software Engineering at Universidade do Porto - FEUP

The instalation and usage guides are provided bellow for better understanding.

[Installation Manual](Manuals/InstallationManual.md)

[Utilization Manual](Manuals/UserManual.md)



#Motavtion and Goal

The motivation behind the development of this tool was a common problem among software engineers. Nowadays, with the constant evolution of software, it may be hard not only to maintain artifacts, but also to keep track of every change on an application. Moreover, mobile applications and in particular Android, has an exponential learning curve that takes developers need to spend more time to fully understand components of Android. 

The main goal of REMAHT is exactly to tackle these problems. This is done by the development of a mixed analysis tool that, when provided with source code of an android mobile application, can analyse it extracting artifacts (Dependency Graphs and intent information) and transform the code, so that the user can interact with the application and check information about activities and fragments' lifecycles. 


#Overview

REMAHT is a mixed technique tool. With this in mind, it is composed by a static analysis and a dynamic analysis phases. The static analysis part involves providing the Kadabra Java Weaver with the source code of the application that is to be analysed. Kadabra will then analyse it and extract the dependency graph and intent information. Also at this stage, kadabra transforms the code, adding missing lifecycle methods of activities and fragments, as well as the script related to the socket.

The dynamic analysis is performed using a desktop application connected to the mobile app through the previously mentioned socket. In this part of the analysis, the user can expore the mobile application and check the diagrams related to activities and fragments to check in real time which activity/fragment is being called and at which state it is.


#Future

#Contibutors

#Contact

#License?
