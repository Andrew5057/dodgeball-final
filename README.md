# Java Dodgeball
A project made by Andrew Yim for AP Computer Science A.

## Setup

### Installing the JDK
Before you play, make sure you have installed the JDK onto your computer. The JDK can be downloaded [here](https://www.oracle.com/java/technologies/downloads/); make sure you have installed JDK 22 or later before proceeding.

### Hosting a server

In order to play dodgeball, one person must start a server. To do this, download and run the [hosting .jar file](https://github.com/Andrew5057/dodgeball-final/blob/main/Host%20Dodgeball.jar).

When it's downloaded, open a new terminal window in whatever folder you downloaded the file ([🪟](https://johnwargo.com/posts/2024/launch-windows-terminal/) [🍎](https://support.apple.com/guide/terminal/open-new-terminal-windows-and-tabs-trmlb20c7888/mac) [🐧](https://www.techrepublic.com/article/linux-101-how-to-quickly-open-a-terminal-in-a-specific-directory/)) and paste the following command:

`
java -jar "Host Dodgeball.jar"
`

Your host name will pop up on your screen, and you should be good to go. Don't forget to join the server!

### Joining a server

Once someone's started a server, everyone else can join! Each player should download the [game file](https://github.com/Andrew5057/dodgeball-final/blob/main/Play%20Dodgeball.jar) and store it in a safe location.

When it's downloaded, open a new terminal window in whatever folder you downloaded the file ([🪟](https://johnwargo.com/posts/2024/launch-windows-terminal/) [🍎](https://support.apple.com/guide/terminal/open-new-terminal-windows-and-tabs-trmlb20c7888/mac) [🐧](https://www.techrepublic.com/article/linux-101-how-to-quickly-open-a-terminal-in-a-specific-directory/)) and paste the following command:

`
java -jar "Play Dodgeball.jar"
`

Enter the host name, and you should join shortly!

## Mechanics

### Controls

- <kbd>WASD</kbd> to move
- Mouse to look
- Left click to throw
- Hold <kbd>C</kbd> to catch
- <kbd>ALT</kbd>+<kbd>F4</kbd> to quit (sorry)

### Rules

Anyone who is hit by a dodgeball will be kicked from the game - unless they catch it, in which case the thrower will be kicked instead.

Beyond that, the rules are up to you!

### Example Rulesets

#### Party Mode
1. Infinite respawns. Feel free to join back in whenever you get out.
2. No spawn camping. It's not hard to figure out where everyone's spawning. It's also not hard to ruin the game given that information.
3. Winner: None. Play to your heart's content!

#### Battle Royale

1. No respawns. When you're out, you're out.
2. Grace period. No throwing for a set time after the game starts - use this time to run away!
3. Winner: Last one standing

### Stock

1. Fixed respawns. Everyone gets to respawn a couple times - but once you're done, that's it.
2. Grace period. No throwing dodgeballs at people who just spawned in. That's just human decency, yall.
3. Winner: Last one standing

## Closing the server

Whenever you're done with the game, the host should focus back into their terminal window and hit <kbd>CTRL</kbd>+<kbd>C</kbd>. Not vital, but it'll save some battery.