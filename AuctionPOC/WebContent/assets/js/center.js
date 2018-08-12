function selected(event) {
    var text = event.textContent;
    var ul = document.getElementsByClassName("nav");
    var children = ul[0].children;
    console.log(children);
    var username = document.getElementById('hidden').value;
    if (text === 'My items') {
        showMyResults(username);
    }

    for (var i = 0; i < children.length; i++) {
        if (children[i].children[0].textContent === text) {
            children[i].children[0].style.color = 'rgb(221, 46, 46)';
        } else {
            children[i].children[0].style.color = 'rgba(255, 255, 255, .5)';
        }
    }
}

showMyResults = function (username) {
    console.log(username);
    var center = document.getElementsByClassName('center');
    console.log(center);
    var products;
    httpGetAsync("http://localhost:8082/AuctionPOC/auctionPage/getItems/kartik", function(response) {
        //console.log(response);
        products = JSON.parse(response);
        //console.log(products[0].productDescription);
	    var myProducts = document.createElement('div');
	    myProducts.classList.add('my-products');
	
	    var card = "";
	    myProducts.innerHTML = card;
	    if (document.getElementsByClassName('my-products')[0] != null)
	    center[0].removeChild(document.getElementsByClassName('my-products')[0]);
	    for (var i = 0; i < products.length; i++) {	
	        card = card + `
	       <div class="card" style="width:20rem;margin:20px 0 24px 0">
	            <img class="card-img-top" src="${'file:///'+products[i].images[0].filepath.replaceAll('\\','/') +'/'+ products[i].images[0].filename}" alt="image" 
	                style="width:100%; border-top-right-radius: 1em; border-top-left-radius: 1em; height:200px">
	            <div class="card-body">
	                <h4 class="card-title">${products[i].productName}</h4>
	                <p class="card-text">${products[i].productDescription}</p>
	                <span class="card-text">Price: INR ${products[i].price}</span> |
	                <span class="card-text">Views: ${products[i].viewCount}</span>
	            </div>
	       </div>
	       `;
	    }
	    myProducts.innerHTML = card;
	    center[0].appendChild(myProducts);
	    // console.log(myProducts);
    });
}

function httpGetAsync(theUrl, callback)
{
    var xmlHttp = new XMLHttpRequest();
    xmlHttp.onreadystatechange = function() { 
        if (xmlHttp.readyState == 4 && xmlHttp.status == 200)
            callback(xmlHttp.responseText);
    }
    xmlHttp.open("GET", theUrl, true); // true for asynchronous
    xmlHttp.send(null);
}

String.prototype.replaceAll = function(search, replacement) {
    var target = this;
    return target.split(search).join(replacement);
};
