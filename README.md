

# Swipy Android App 
=============================

This is a app which is demo app for swiping up/down the music file and able to play and pause the music.
- listen the song
- play/pause the song
- swipe up/down to navigate

## Building the Sample App

First, clone the repo:

`git clone git@github.com:Shubham-Modi08/Swipy.git`


Building the sample then depends on your build tools.

### Android Studio (Recommended)

(These instructions were tested with Android Studio version Arctic Fox (2020.3.1))

* Open Android Studio and select `File->Open...` or from the Android Launcher select `Import project (Eclipse ADT, Gradle, etc.)` and navigate to the root directory of your project.
* Select the directory or drill in and select the file `build.gradle` in the cloned repo.
* Click 'OK' to open the the project in Android Studio.
* A Gradle sync should start, but you can force a sync and build the 'app' module as needed.

### Gradle (command line)

* Build the APK: `./gradlew build`

## Running the Sample App

Connect an Android device to your development machine.

### Android Studio

* Select `Run -> Run 'app'` (or `Debug 'app'`) from the menu bar
* Select the device you wish to run the app on and click 'OK'

### Gradle

* Install the debug APK on your device `./gradlew installDebug`

