
function chngButton() {
        document.getElementById('compButton').innerHTML = 'Not Computers';
}

var HTbutton = document.getElementById('compButton');
    
    HTbutton.addEventListener("click", chngButton);

var Nbutton = document.getElementById("nothingButton");
var Menu = document.getElementById("theMenu");

function NewMenu() {
    
    Menu.classList.toggle("show-menu");
    
}    

Nbutton.addEventListener("click", NewMenu);
    
function closeMenu() {
    
    if (Menu.classList.contains("show-menu") == true) {
        Menu.classList.remove("show-menu");
    }
}

fizzy = document.getElementById('soda');

function displayCount() {
    
    
    for (var i = 1; i <= 100; i++) {
        
        if ( i % 3 == 0) {
            document.write("Fizz");
        }
        
        else if (i % 5 == 0) {
            document.write("Buzz");
        }
        
        else {
            document.write(i);
        }
        document.write(", ");
    }
    
    document.body.style.backgroundColor = "blue";
}

fizzy.addEventListener('click', displayCount);