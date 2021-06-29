# SMART
This repository contains the code which implements a methodology for reverse engineering android mobile applications. The methodology was developed in the context of a final dissertation of the Master in Software Engineering course at Universidade do Porto - FEUP.

The installation and utilization guides are provided bellow for easier usage of the tool.

[Installation Manual](Manuals/InstallationManual.md)

[Utilization Manual](Manuals/UserManual.md)



## Motivation and Goal

The motivation behind the development of this tool was the need to find a solution to a common problem among software engineers. Nowadays, with the constant evolution of software, it may be hard not only to maintain artifacts, but also to keep track of every change on an application. Moreover, Android has an exponential learning curve that makes developers need to spend more time to fully understand all the components of Android and their lifecycles in the case of Fragments and Activities. 

The main goal of SMART is exactly to tackle these problems. This is done by the development of a mixed analysis reverse engineering methodology that takes advantage of the source code of an android mobile application, to analyse it extracting artifacts (Dependency Graphs and intent information) and transform the code, so that the user can interact with his application and check information about activities and fragments' lifecycles. 


## Overview

SMART is a mixed technique methodology. With this in mind, it is composed of a static analysis and a dynamic analysis phases. The static analysis part involves providing the Kadabra Java Weaver with the source code of the application that is to be analysed. Kadabra will then analyse it and extract the dependency graph and intent information. Also at this stage, Kadabra transforms the code to later allow the dynamic analysis to take place, adding missing lifecycle methods of activities and fragments, as well as the script related to the socket.

The dynamic analysis is performed using a desktop application connected to the mobile app through the previously mentioned socket. In this part of the analysis, the user can explore the mobile application and check the diagrams related to activities and fragments on the desktop app in order to check in real time which activity/fragment is being called and at which state it is.


## Future Work

Regarding future work, SEMANTIC has some limitations that can be improved in future iterations. Starting with code transformation, SEMANTIC's future work should involve the implementation of a method to scan for the launcher activity dynamically which would improve SEMANTIC's versatility to handle applications. 

In the case of activities and fragments the implementation of a way to find the classes correspondent to these elements dynamically will also be implemented as future work. Searching for all fragments' sub classes (e.g., FragmentActivity, ListFragment ,etc.) will enrich SEMANTIC's quality widening its use cases to applications that may not use directly the class "Fragment".

Moreover, a nice-to-have requirement that may be implemented is a method that sends information from the desktop app back to the mobile app informing that the correct life-cycle method was already displayed.


## Contributions

Master Student: Francisco Serrão - franciscoserrao@me.com

Supervisor: Nuno Flores - nuno.flores@gmail.com

Co-Supervisor: Ana Paiva - apaiva@fe.up.pt

Research Colaborator: João Bispo - joaobispo@gmail.com 

## License

Copyright 2021 University of Porto - FEUP

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at:

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.

