# Installation Manual

This installation guide constains instructions related to the installation REMAHT divided into two different parts: **Kadabra Tool** (Static Analysis component) and the **REMAHT Tool** (Dynamic Analysis component). Before installing any of the two, one must ensure that some prerequisites are followed. 

In the first stage, the following software must be installed:

  - [Java SDK](https://www.oracle.com/pt/java/technologies/javase/javase-jdk8-downloads.html) 
  
  - [Android Studio](https://developer.android.com/studio?gclid=Cj0KCQjwkZiFBhD9ARIsAGxFX8Aipaq7tc9u3yKlWyLQrfQ1Y5uf4ZeKiN0Oqvc0UDgw2HBcdNHH6joaArRPEALw_wcB&gclsrc=aw.ds)
  
  - [Android Emulator / Device](https://developer.android.com/studio/run/managing-avds)
  
  - [Apache Netbeans (used 12.3)](https://netbeans.apache.org/download/index.html)

  - [Kadabra Java Weaver](http://specs.fe.up.pt/tools/kadabra/)


For the steps of the installation process itself, follow the enumeration:

 1. Download this repository to your local folder.
 
 2. As a first instance, build the application that will be analysed with the methodology in order to generate the r folder of the project. 
 
Note 1: r folder can be found in app/build/generated/.../r/ 

 3. Open Kadabra Java Weaver.
 
 4. On the **middle** tab (inserir), select the SocketV2.Lara file as the configuration script.

Note 2: the final
