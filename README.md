
# react-native-wallpaper-manager

## Getting started

`$ npm install react-native-wallpaper-manager --save`

### Mostly automatic installation

`$ react-native link react-native-wallpaper-manager`

### Manual installation


#### iOS

1. In XCode, in the project navigator, right click `Libraries` ➜ `Add Files to [your project's name]`
2. Go to `node_modules` ➜ `react-native-wallpaper-manager` and add `RNWallv.xcodeproj`
3. In XCode, in the project navigator, select your project. Add `libRNWallv.a` to your project's `Build Phases` ➜ `Link Binary With Libraries`
4. Run your project (`Cmd+R`)<

#### Android

1. Open up `android/app/src/main/java/[...]/MainActivity.java`
  - Add `import com.reactlibrary.RNWallvPackage;` to the imports at the top of the file
  - Add `new RNWallvPackage()` to the list returned by the `getPackages()` method
2. Append the following lines to `android/settings.gradle`:
  	```
  	include ':react-native-wallpaper-manager'
  	project(':react-native-wallpaper-manager').projectDir = new File(rootProject.projectDir, 	'../node_modules/react-native-wallpaper-manager/android')
  	```
3. Insert the following lines inside the dependencies block in `android/app/build.gradle`:
  	```
      compile project(':react-native-wallpaper-manager')
  	```

#### Windows
[Read it! :D](https://github.com/ReactWindows/react-native)

1. In Visual Studio add the `RNWallv.sln` in `node_modules/react-native-wallpaper-manager/windows/RNWallv.sln` folder to their solution, reference from their app.
2. Open up your `MainPage.cs` app
  - Add `using Wallv.RNWallv;` to the usings at the top of the file
  - Add `new RNWallvPackage()` to the `List<IReactPackage>` returned by the `Packages` method


## Usage
```javascript
import RNWallv from 'react-native-wallpaper-manager';

// TODO: What to do with the module?
RNWallv;
```