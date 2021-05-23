# Utilization Manual

This documents comes to show an example on how to complete the entire proposed methodology (REMAHT) to an aplication under analysis.

In order to complete the process, there is the need to already have installed some prerequisites. Please refer to the [Installation Manual](/Manuals/InstallationManual.md) to access the links for downloading the needed software.

1. Fully build the project in Android Studio so that it is possible to acquire the r folder containing build data.

2. Find the r folder.

<code> ` Note: usually placed in "app/build/generated.../r" `</code>

3. Open Kadabra and use the configurations described in the **Installation manual**. 

<code> `Note: add r folder and the application's folder that will be analysed to kadabra´s sources (options tab)` </code>

 <img src="/Images/r.png" alt="r"/>

4. Save as the <code> `<name>.config` </code> file and on the program tab click start option. Image below for example.
 
 <img src="/Images/start.png" alt="example1"/>
 
5. After this, you can open the kadabra folder. In it, a folder named <code> `Static Analysis`</code> can be found with a file containing information regarding all intents and intent filters of the app (<code> `Intent&IntentFilters.txt` </code>). 

 <img src="/Images/files.png" alt="example2"/>
 
Also, a <code> `dependencyGraph.txt` </code> file contains the code needed to generate a Class Dependency Graph of the application using the tool [WebGraphviz](http://www.webgraphviz.com).

6. In order to generate the graph, go to the WebGraphviz website and place the script contained in the `dependencyGraph.txt` file.

At this stage, the static analysis is complete. The artifacts are the <code> `Intent&IntentFilters.txt` </code> and <code> `dependencyGraph.txt` </code> files, as well as the transformed code by kadabra.

7. Open the application's folder and replace the file which was used for the analysis.

8. Open the `manifest.xml` file of the application and add the following permissions (if not already existing) in order to enable the socket necessary for the dynamic analysis:


```<uses-permission android:name="android.permission.INTERNET"/>```
 
```<uses-permission android:name="android.permission.READ_EXTERNAL_STORAGE"/>```
 
This documents comes to show an example on how to complete the entire proposed methodology (REMAHT) to an aplication under analysis.

 
 # Utilization Manual
 
 
 
 
