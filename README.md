# JunctionX-Hunter-Android
This is the Android App for the backend for Project Lighthouse, a proof of concept by Team Hunter at JunctionxSeoul 2021.
## Case Problem Statement
As the rest of the world is moving forwards with technology, making leaps and bounds in accessibility and convenience, we are leaving behind those with mobility challenges of any kind, turning a blind eye towards people who deserve every bit of love, care, and respect as the rest of us. To prevent this indignity, Autocrypt wants to create mobility solutions that will help mobility challenged people be as excited to go outside as anyone else. And that’s where we come in! We’re a team of Android Developers, Backend Developers, Frontend Developers, UI/UX Designer and Data Science Entrepreneur with a vision for tomorrow that can perfectly incorporate the Fleet Management System Autocrypt is already working towards.

## The Team
Sungmin Jung: Android Developer & Frontend Developer

Sooyeon Kim: Android Developer & Frontend Developer

Changmin Kim: Backend Developer

Sunghyun Kang: Backend developer

Sungyun Cho: UI/UX Designer

[Srujan Gupta](https://www.linkedin.com/in/notsrujangupta): Data Science Entrepreneur

## Our Approach
Our basic premise is fairly straightforward. We identify problems that disproportionately hurt those who are mobility challenged, find technically feasible solutions for them, and make them free of cost for those who need it. But there’s a catch. While these problems do affect mobility challenged people way more, they still heavily negatively impact people with no such challenges. Our solutions are built in such a way that they have tangible advantages for everyone, but free only for the mobility challenged. And that’s where the commercial viability comes from. Our envisioned model will be a one stop app that takes care of all problems faced by mobility challenged people, but is also incredibly convenient for everyone else.

## Proof of Concept
For our proof of concept, the first problem we came across was that of visually impaired people trying to ride buses. We call it Project BusPharos, after the first lighthouse in Alexandria. As of today, most visually impaired people are heavily dissatisfied with the support from the public transportation system they interact with on a daily basis. A lot of the time, they end up just not leaving the house or asking for assistance in other ways. It is tough to reach the bus destination, find which bus they need to climb, and then actually climb it on time. It is extremely common that people miss their buses altogether. And even when they do climb the bus, they often have to stand because looking for a seat with the hand and cane ends up being extremely hard, especially if other people in the bus are not able to help them.

To solve that, we are essentially using a beacon system. The user pings the appropriate bus with the app, the app guides them to the bus, and they can ride it without worry. To make everything more powerful, we are using most of the accessibility features provided by Google. That means all gestures and interactions are top notch and convenient to implement. Everything is voice activated.

## Specifics
More specifically, here is the Launch Screen for the bus riding section of our App. It is built for convenience, with information like current bus stop, voice search for the visually impaired, a button for saving bus numbers and settings. The special buttons can be looked at more carefully on our figma board. The App then gives voice confirmation of location and bus numbers chosen, allowing the user to re-search for a bus if they are not satisfied. Else, they can proceed to make a reservation. While waiting for the bus, the screen gives selection information such as bus number, type of bus, Estimated Time of Arrival, and an Abort button. The user is given audio and visual cues to confirm abortion. Using Autocrypt’s own future service of FMS, the app will be notified when the bus is nearby and the user gets an audio visual cue for the same. To complete the connection of the beacon system, there is also a beacon for the bus and the bus stop. The bus beacon helps the driver know that somebody is intending, or trying, to climb the bus on the stop, and informs them to wait. When the visually impaired person has sat, the bus driver app informs them that they can now move. The bus stop uses GPS Data to identify users who may breach social etiquette and leave the bus stop after calling the service. Once they’re in the bus, the app will use data from the phone sensors to identify if the person is sitting yet so the driver is notified only when the visually impaired person has found a seat before moving on.

## The Future
We intend on collecting sitting vs standing data and creating models when we’re able to perfect our work. Moreover, we also have other ideas within the same business model of non mobility challenged people paying a premium for other sections of the app. An idea is to use our apps to book parking spaces, also allowing people who can’t walk to book their space further in advance than those who can. We plan on implementing typical ideas such as using DMS data in the vehicles to help them stay within certain limits of speed, incline, etc. What we’re really pitching today, is a way to privatise mobility equality because we believe any public space that allows access to anyone is a public space that can help everyone.
Enjoy the Ride!
