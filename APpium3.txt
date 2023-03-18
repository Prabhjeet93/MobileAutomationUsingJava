
Start Appium server from command prompt

MAC -> install homebrew.
/bin/bash -c "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/HEAD/install.sh)"

install brew node
$ brew install node

$ node -v
$ npm -v

$ npm install -g appium
$npm install wd
start appium
$ appium &

For Windows

Running Appium on Windows
Setup
To get started:

1. Download latest node and npm tools MSI (version >= 6.0). The npm and nodejs paths should be in your PATH environment variable.
2. Open admin cmd prompt
3. Run the command $ npm install -g appium ,which will install Appium from NPM
4. To start Appium, you can now simply run $ appium ,from the prompt.

It will start the appium server from command prompt.

We can put this in prerequiste method and run these commands from the code it self.


We can run two or more appium server as well for the parallel testing.
Open different command prompt and While runnning appium provide a different ports

$ appium -p 4227
$ appium -p 4228
$ appium -p 4229

FOr parallel testing we need to give UID as well. check archive code for that.


For QR code need to install zxing lib











