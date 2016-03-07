# Tank-Buddy
Gasoline Consumption tracker App project for Mobiles Course at Metropolia UAS.

It is an Android application to keep track gasoline consumption of a car.
On the main activity, user is shown the current average gasoline consumption. 
The average consumption is shown in big numbers either in l/100 km or mpg units. 
Display unit selection is user selectable. Consumption calculation is based on the stored odometer
and refueling amounts. On the main activity also the minimum and maximum gasoline
consumption and consumption between the last refueling times are shown.
There is a way to switch from the main activity to the second activity where the
user is able to enter the current odometer value and the amount of fuel when refueling.
These odometer and fuel are stored to a local non-volatile storage like the following

Date         Odometer value (km)  Fuel amount (l)
16.12.2015         120567             42
2.1.2016           120869             38
9.1.2016           121146             43
13.1.2016          121459             39

From the main activity window there is also be a way to get to the third activity
where the date, odometer and fuel amount information are shown in a scrollable list for
checking the entered values in general.

