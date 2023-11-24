## Tool to import project specific settings

Me and some colleagues had the problem that some plugins used project specific settings that we wanted to we wanted to be Application wide settings.
Instead of forking and modifying every single plugin that we needed this tool allows you to sync settings 

## Usage
  1. Copy the Settings you need to sync from any projected where they are configured correctly to a new folder
    - Make sure you don't copy stuff like compiler/sonar/other settings that are actually project specific
  2. Go to Settings -> Tools -> Import Intellij Settings: Set the path to the folder you just created
  3. In Toolbar -> Tools: Press "Import Settings" to copy them to the .idea folder of the currently opened project
 
### Todo
- Actuall Null checks instead of forcing NPEs with !!
- Add check if Settings Path has been set to make sure you don't accidently import your whole Users directory or whatever the default for your OS is
- Maybe add a Popup asking if you want to import settings if the project hasn't been opened in IntelliJ before + Settings to enable/disable it
- Maybe add configurable functionality to remove project specific settings from certain XMLs
- Make Settings prettier
