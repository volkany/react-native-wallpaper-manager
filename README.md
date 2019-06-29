
# react-native-wallpaper-manager

## Getting started

`$ npm install react-native-wallpaper-manager --save`

### Mostly automatic installation

`$ react-native link react-native-wallpaper-manager`

### Manual installation
#### Android

1. Open up `android/app/src/main/java/[...]/MainActivity.java`
  - Add `import com.volkan.WallpaperManager;` to the imports at the top of the file
  - Add `new WallpaperManager()` to the list returned by the `getPackages()` method
2. Append the following lines to `android/settings.gradle`:
  	```
  	include ':react-native-wallpaper-manager'
  	project(':react-native-wallpaper-manager').projectDir = new File(rootProject.projectDir, 	'../node_modules/react-native-wallpaper-manager/android')
  	```
3. Insert the following lines inside the dependencies block in `android/app/build.gradle`:
  	```
      compile project(':react-native-wallpaper-manager')
  	```

## Usage
```javascript
import WallpaperManager from 'react-native-wallpaper-manager';
...
WallpaperManger.setWallpaper("https://picsum.photos/id/881/1080/2560", WallpaperManger.ALL, (err, resultCode) => {
	if(err || resultCode === -1) {
		if(err === "loadFailed") return alert("Unable to load the photo.")
		else return alert("Unknown error.")
	}
	alert("Wallpaper set!")
})

```