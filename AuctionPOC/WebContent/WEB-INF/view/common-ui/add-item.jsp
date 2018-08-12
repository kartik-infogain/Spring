<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en" class="no-js">
<head>
	<meta charset="UTF-8" />
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Auction POC | Add item</title>
	<meta name="description" content="This is used to add new items for the auction" />
	<meta name="keywords" content="auction, add items" />
	<meta name="author" content="kartik" />
	<link rel="stylesheet" type="text/css" href="/AuctionPOC/assets/css/normalize.css" />
	<link rel="stylesheet" type="text/css" href="/AuctionPOC/assets/css/demo.css" />
	<link rel="stylesheet" type="text/css" href="/AuctionPOC/assets/css/component.css" />
	<link rel="stylesheet" type="text/css" href="/AuctionPOC/assets/css/cs-select.css" />
	<link rel="stylesheet" type="text/css" href="/AuctionPOC/assets/css/cs-skin-boxes.css" />
	<script src="/AuctionPOC/assets/js/modernizr.custom.js"></script>
	
	<style>
		#image-product {
			width: 200px;
			height: 200px;
			position: relative;
		}

		#navi {
			width: 100%;
			height: 100%;
			position: absolute;
			top: 0;
			left: 0;
		}

		#infoi,
		#files {
			width: 100%;
			height: 100%;
			position: absolute;
			top: 0;
			opacity: 0;
			left: 0;
		}


		#infoi {
			z-index: 10;
		}
	</style>
</head>

<body>
	<div class="container">
		<div class="fs-form-wrap" id="fs-form-wrap">
			<div class="fs-title">
				<h1>Add Product</h1>
				<div class="codrops-top">
					<a class="codrops-icon codrops-icon-prev" href="auctionPage">
						<span>Previous Page</span>
					</a>
					
					<a class="codrops-icon codrops-icon-info" href="#">
						<span>Here you can add product which you want to be auctioned</span>
					</a>
				</div>
			</div>
			<form id="myform" class="fs-form fs-form-full" autocomplete="off" action="form" method="post">
				
				<ol class="fs-fields">
					<li>
						<label class="fs-field-label fs-anim-upper" for="q1">What's the name of the product?</label>
						<input class="fs-anim-lower" id="q1" name="productName" type="text" placeholder="Anything" required/>
						<input type="hidden" class="fs-anim-lower" name="username" id ="username" value="<%= session.getAttribute("username")%>">
					</li>
					<li>
						<label class="fs-field-label fs-anim-upper" for="q2" data-info="Please use spaces to separate">Any Tags?</label>
						<input class="fs-anim-lower" id="q2" name="tags" type="text" placeholder="To make your product trendy..." required/>
					</li>
					<li>
						<label class="fs-field-label fs-anim-upper" for="q5">What's your budget?</label>
						<input class="fs-mark fs-anim-lower" id="q5" name="price" type="number" placeholder="1000" />
					</li>
					<li>
						<label class="fs-field-label fs-anim-upper" for="q3">Can you add a photo too?</label>
						<!-- <div class=""><img src="" alt="Click to get an image" id="img-prod"></div>
						<input class="fs-anim-lower" style="display: none;" name="q3" type="file" accept="image/*"/> -->
						<div id="image-product">
							<div id="navi">
								<img alt="" id="b" style="height: 200px; width: 200px;" class="fs-anim-lower">
							</div>
							<div id="infoi">
								<input class="fs-anim-lower" type="file" id="files" name="fileName" />
							</div>
							<input type="hidden" class="fs-anim-lower" name="image" id ="image" >
							<!-- <output id="list"></output> -->
						</div>
					</li>
					<!-- Photo of the product... -->
					<li>
						<label class="fs-field-label fs-anim-upper" for="q4">Just a description left..</label>
						<textarea class="fs-anim-lower" id="q4" name="desc" placeholder="Describe here" required></textarea>
					</li>
					<!-- <li>
						<label class="fs-field-label fs-anim-upper" for="q5">What's your budget?</label>
						<input class="fs-mark fs-anim-lower" id="q5" name="q5" type="number" placeholder="1000" step="100" min="100" />
					</li> -->
				</ol>
				<!-- /fs-fields -->
				<button class="fs-submit" type="submit">Send answers</button>
			</form>
			<!-- /fs-form -->
		</div>
		

	</div>
	<!-- /container -->
	<script src="/AuctionPOC/assets/js/classie.js"></script>
	<script src="/AuctionPOC/assets/js/selectFx.js"></script>
	<script src="/AuctionPOC/assets/js/fullscreenForm.js"></script>
	<script>
		function handleFileSelect(evt) {
			var files = evt.target.files; // FileList object

			// Loop through the FileList and render image files as thumbnails.
			for (var i = 0, f; f = files[i]; i++) {

				// Only process image files.
				if (!f.type.match('image.*')) {
					continue;
				}

				var reader = new FileReader();

				// Closure to capture the file information.
				reader.onload = (function (theFile) {
					return function (e) {
						document.getElementById('b').setAttribute("src", e.target.result);
						document.getElementById("image").setAttribute("value",e.target.result);
					};
				})(f);

				// Read in the image file as a data URL.
				reader.readAsDataURL(f);
			}
		}

		document.getElementById('files').addEventListener('change', handleFileSelect, false);
		(function () {
			var formWrap = document.getElementById('fs-form-wrap');

			[].slice.call(document.querySelectorAll('select.cs-select')).forEach(function (el) {
				new SelectFx(el, {
					stickyPlaceholder: false,
					onChange: function (val) {
						document.querySelector('span.cs-placeholder').style.backgroundColor = val;
					}
				});
			});

			new FForm(formWrap, {
				onReview: function () {
					classie.add(document.body, 'overview'); // for demo purposes only
				}
			});
		})();
	</script>
</body>

</html>