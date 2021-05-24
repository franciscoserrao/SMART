# Utilization Manual

This documents comes to show an example on how to apply the entire proposed methodology (REMAHT) to an aplication under analysis.

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

  ## Dynamic Analysis
 
7. Open the application's folder and replace the file which was used for the analysis.

 8. Delete R class of the transformed folder.

9. Open the `manifest.xml` file of the application and add the following permissions (if not already existing) in order to enable the socket necessary for the dynamic analysis:

<code> ```<uses-permission android:name="android.permission.INTERNET"/>``` </code>
 
<code> ```<uses-permission android:name="android.permission.READ_EXTERNAL_STORAGE"/>``` </code>
 
 10. Open [NetBeans](https://netbeans.apache.org/download/index.html) and run the <code> `MainFrameServer.jframe` </code>
 
 <code> `Note: verify the port in the JFrame components to match the port on the one in the transformed code`</code> 
 
  <img src="/Images/port.png" alt="port"/> <img src="/Images/port2.png" alt="port2"/>
 
 
 11. Run and start exploring application and see results in the java desktop application.

 
 
The methodology process is over at this point and the graphs in the REMAHT app heps to understand and acquire information regarding activities and fragments in the application under analysis, such as their name and lifecycle state throughout the exploration.
 
