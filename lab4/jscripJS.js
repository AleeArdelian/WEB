
function myFunction() {
    const links = document.getElementsByTagName("a");
    for(let i=0; i<links.length; i++)
    {
        if(links[i].href)
        {
            links[i].style.color = 'orange';
        }
    }
}

let val=1;
function Function() {
    switch (val) {
        case 1:
            document.getElementById("img").style.backgroundImage = "url(32738A6E00000578-3504412-image-a-6_1458654517341.jpg)";
            val=2;
            break;
        case 2:
            document.getElementById("img").style.backgroundImage = "url(images.jpg)";
            val=3;
            break;
        case 3:
            document.getElementById("img").style.backgroundImage = "url(enhanced-buzz-1492-1379411828-15_0.jpg)";
            val=4;
            break;
        case 4:
            document.getElementById("img").style.backgroundImage = "url(photo-1500382017468-9049fed747ef.jpg)";
            val = 5;
            break;
        case 5:
            document.getElementById("img").style.backgroundImage = "url(water-lily-3784022__340.jpg)";
            val = 1;
            break;
    }

}