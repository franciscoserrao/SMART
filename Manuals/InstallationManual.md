# Installation Manual

This installation guide constains instructions related to the installation REMAHT divided into two different parts: **Kadabra Tool** (Static Analysis component) and the **REMAHT Tool** (Dynamic Analysis component). Before installing any of the two, one must ensure that some prerequisites are followed. 

In the first stage, the following software must be installed:

  - [Java SDK](https://www.oracle.com/pt/java/technologies/javase/javase-jdk8-downloads.html) 
  
  - [Android Studio](https://developer.android.com/studio?gclid=Cj0KCQjwkZiFBhD9ARIsAGxFX8Aipaq7tc9u3yKlWyLQrfQ1Y5uf4ZeKiN0Oqvc0UDgw2HBcdNHH6joaArRPEALw_wcB&gclsrc=aw.ds)
  
  - [Android Emulator / Device](https://developer.android.com/studio/run/managing-avds)
  
  - [Apache Netbeans (used 12.3)](https://netbeans.apache.org/download/index.html)


The following enumation comes to show each of the steps of the installation process:

 1. Download this repository to your local folder.
 
 
 2. Download [Kadabra Java Weaver](http://specs.fe.up.pt/tools/kadabra/) and saved to a  <code> `<directory>` </code>.
 
  
 3. Go to <code> `<User>/.../<directory>/kadabra/` </code>
 
  
 4. Create a file with the extension <code> `<name>.config` </code>
  
  
 5. Open Kadabra Java Weaver
   
  
 6. On the **middle** tab (Options), select the <code> `SocketV2.Lara` </code> file as the "Aspect" script.
  
  
 7. Add the directory <code> `app/src/main/java/<directory>` </code> and the <code> `r`</code> folder to the **Source** atribute.
  
<code> `Note: <directory> corresponds to the folder where the code that will be analysed is`</code>
  
  
 8. Select the output folder where transformed code should be placed
  
 <code> `Note: It is not recommended to use the path to the same <directory> as source folder` </code>
  
  
 **(OPTIONAL)** 9. Create debug file in kadabra folder (no entension).
  
 **(OPTIONAL)** 9.1. Select Debug mode and Lara Trace
  
  
  10. Add classpaths for build libraries <code> `<User>/.gradle/caches/` </code>. 
  
<code>   `Note: For performance improvement one can go to <Application Analysed/.idea/libraries/> and added to caches/ one should select each of the libraries that the application uses` </code>

  
  11. Select options: <code> `Fully qualified name` </code>, <code> `Copy resources to output folder`</code>, <code> `Format Code and organize imports` </code> and <code> `Fully Qualified Names` </code>
  
<code> `Note: the final configuration should match the following image` </code>


  12. Click **Save as...** and select the <code> `<name>.config` </code> file created in step 4.

   13. Open terminal and run command <code> `ifconfig |grep inet` </code> to get local ip and place it in the <code> ` SocketV2.Lara ` </code> file. Example bellow.
   
   <img src="/Images/ip1.png" alt="ip1"/>
  <img src="/Images/ip2.png" alt="ip2"/>

## Example Configuration

  <img src="/Images/kadabra.png" alt="Configuration"/>
    <img src="/Images/kadabra1.png" alt="Configuration2"/>  <img src="/Images/kadabra2.png" alt="Configuration3"/>
