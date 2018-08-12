<<<<<<< HEAD
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Auction POC | Forget Password</title>
<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/particles.js@2.0.0/particles.min.js"></script>

<style>
body {
	margin: 0;
	padding: 0;
}

.contain {
	width: 100%;
	height: 430px;
}

/* ---- particles.js container ---- */
#particles-js {
	background-color: #000;
	background-size: cover;
	height: 100%;
}

.login {
	background: white;
	opacity: .8;
	padding: 2em;
	border: #ccc 2px solid;
	position: absolute;
	top: 20%;
	left: 40%;
	width: 25%;
}

.header {
	margin-bottom: 25px;
}

.disp {
	display: none;
}
</style>
<script>
	function validateForm() {
		var x = document.forms["myForm"]["id"].value;

		if (x.length == 0) {
			alert("Enter the username");
			return false;
		}

		x = document.forms["myForm"]["password"].value;
		var y = document.forms["myForm"]["confirmPassword"].value;
		if (x.length == 0 && y.length() == 0) {
			alert("Enter the password");
			return false;
		}

		if (!x.equals(y)) {
			alert("Password and Confirm Password should be same");
			return false;
		}
	}
</script>
</head>


<body>
	<div class="contain" id="particles-js">
		<div class="login">
			<div class="header">
				<div class="heading">
					<h3>Change your password</h3>
				</div>
			</div>

			<!-- Login Form Details -->

			<div id="loginForm">
				<form method="post" onsubmit="return validateForm()" name="myForm"
					action="requestChange">
					<div class="form-group">
						<label for="username" class="card-title"><kbd>ID :</kbd></label> <input
							type="text" name="objectID" class="form-control"
							placeholder="Enter the id from email" required />
					</div>
					<div class="form-group">
						<label for="password" class="card-title"><kbd>Password
								:</kbd></label> <input type="password" name="password" class="form-control"
							placeholder="******" required />
					</div>
					<div class="form-group">
						<label for="password" class="card-title"><kbd>Confirm
								password :</kbd></label> <input type="password" name="confirmPassword"
							class="form-control" placeholder="******" required />
					</div>
					<div>${message}</div>
					<button type="submit" class="btn btn-warning">Submit</button>
				</form>
			</div>
			<span>Not Registered ? <a href="register">Register here..</a></span>
		</div>

	</div>
	<script type="text/javascript">
		particlesJS("particles-js", {
			"particles" : {
				"number" : {
					"value" : 380,
					"density" : {
						"enable" : true,
						"value_area" : 800
					}
				},
				"color" : {
					"value" : "#ffffff"
				},
				"shape" : {
					"type" : "circle",
					"stroke" : {
						"width" : 0,
						"color" : "#000000"
					},
					"polygon" : {
						"nb_sides" : 5
					},
					"image" : {
						"src" : "img/github.svg",
						"width" : 100,
						"height" : 100
					}
				},
				"opacity" : {
					"value" : 0.5,
					"random" : false,
					"anim" : {
						"enable" : false,
						"speed" : 1,
						"opacity_min" : 0.1,
						"sync" : false
					}
				},
				"size" : {
					"value" : 3,
					"random" : true,
					"anim" : {
						"enable" : false,
						"speed" : 40,
						"size_min" : 0.1,
						"sync" : false
					}
				},
				"line_linked" : {
					"enable" : true,
					"distance" : 150,
					"color" : "#ffffff",
					"opacity" : 0.4,
					"width" : 1
				},
				"move" : {
					"enable" : true,
					"speed" : 6,
					"direction" : "none",
					"random" : false,
					"straight" : false,
					"out_mode" : "out",
					"bounce" : false,
					"attract" : {
						"enable" : false,
						"rotateX" : 600,
						"rotateY" : 1200
					}
				}
			},
			"interactivity" : {
				"detect_on" : "canvas",
				"events" : {
					"onhover" : {
						"enable" : true,
						"mode" : "grab"
					},
					"onclick" : {
						"enable" : true,
						"mode" : "push"
					},
					"resize" : true
				},
				"modes" : {
					"grab" : {
						"distance" : 140,
						"line_linked" : {
							"opacity" : 1
						}
					},
					"bubble" : {
						"distance" : 400,
						"size" : 40,
						"duration" : 2,
						"opacity" : 8,
						"speed" : 3
					},
					"repulse" : {
						"distance" : 200,
						"duration" : 0.4
					},
					"push" : {
						"particles_nb" : 4
					},
					"remove" : {
						"particles_nb" : 2
					}
				}
			},
			"retina_detect" : true
		});
	</script>
</body>
=======
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Auction POC | Forget Password</title>
<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/particles.js@2.0.0/particles.min.js"></script>

<style>
body {
	margin: 0;
	padding: 0;
}

.contain {
	width: 100%;
	height: 430px;
}

/* ---- particles.js container ---- */
#particles-js {
	background-color: #000;
	background-size: cover;
	height: 100%;
}

.login {
	background: white;
	opacity: .8;
	padding: 2em;
	border: #ccc 2px solid;
	position: absolute;
	top: 20%;
	left: 40%;
	width: 25%;
}

.header {
	margin-bottom: 25px;
}

.disp {
	display: none;
}
</style>
<script>
	function validateForm() {
		var x = document.forms["myForm"]["id"].value;

		if (x.length == 0) {
			alert("Enter the username");
			return false;
		}

		x = document.forms["myForm"]["password"].value;
		var y = document.forms["myForm"]["confirmPassword"].value;
		if (x.length == 0 && y.length() == 0) {
			alert("Enter the password");
			return false;
		}

		if (!x.equals(y)) {
			alert("Password and Confirm Password should be same");
			return false;
		}
	}
</script>
</head>


<body>
	<div class="contain" id="particles-js">
		<div class="login">
			<div class="header">
				<div class="heading">
					<h3>Change your password</h3>
				</div>
			</div>

			<!-- Login Form Details -->

			<div id="loginForm">
				<form method="post" onsubmit="return validateForm()" name="myForm"
					action="requestChange">
					<div class="form-group">
						<label for="username" class="card-title"><kbd>ID :</kbd></label> <input
							type="text" name="objectID" class="form-control"
							placeholder="Enter the id from email" required />
					</div>
					<div class="form-group">
						<label for="password" class="card-title"><kbd>Password
								:</kbd></label> <input type="password" name="password" class="form-control"
							placeholder="******" required />
					</div>
					<div class="form-group">
						<label for="password" class="card-title"><kbd>Confirm
								password :</kbd></label> <input type="password" name="confirmPassword"
							class="form-control" placeholder="******" required />
					</div>
					<div>${message}</div>
					<button type="submit" class="btn btn-warning">Submit</button>
				</form>
			</div>
			<span>Not Registered ? <a href="register">Register here..</a></span>
		</div>

	</div>
	<script type="text/javascript">
		particlesJS("particles-js", {
			"particles" : {
				"number" : {
					"value" : 380,
					"density" : {
						"enable" : true,
						"value_area" : 800
					}
				},
				"color" : {
					"value" : "#ffffff"
				},
				"shape" : {
					"type" : "circle",
					"stroke" : {
						"width" : 0,
						"color" : "#000000"
					},
					"polygon" : {
						"nb_sides" : 5
					},
					"image" : {
						"src" : "img/github.svg",
						"width" : 100,
						"height" : 100
					}
				},
				"opacity" : {
					"value" : 0.5,
					"random" : false,
					"anim" : {
						"enable" : false,
						"speed" : 1,
						"opacity_min" : 0.1,
						"sync" : false
					}
				},
				"size" : {
					"value" : 3,
					"random" : true,
					"anim" : {
						"enable" : false,
						"speed" : 40,
						"size_min" : 0.1,
						"sync" : false
					}
				},
				"line_linked" : {
					"enable" : true,
					"distance" : 150,
					"color" : "#ffffff",
					"opacity" : 0.4,
					"width" : 1
				},
				"move" : {
					"enable" : true,
					"speed" : 6,
					"direction" : "none",
					"random" : false,
					"straight" : false,
					"out_mode" : "out",
					"bounce" : false,
					"attract" : {
						"enable" : false,
						"rotateX" : 600,
						"rotateY" : 1200
					}
				}
			},
			"interactivity" : {
				"detect_on" : "canvas",
				"events" : {
					"onhover" : {
						"enable" : true,
						"mode" : "grab"
					},
					"onclick" : {
						"enable" : true,
						"mode" : "push"
					},
					"resize" : true
				},
				"modes" : {
					"grab" : {
						"distance" : 140,
						"line_linked" : {
							"opacity" : 1
						}
					},
					"bubble" : {
						"distance" : 400,
						"size" : 40,
						"duration" : 2,
						"opacity" : 8,
						"speed" : 3
					},
					"repulse" : {
						"distance" : 200,
						"duration" : 0.4
					},
					"push" : {
						"particles_nb" : 4
					},
					"remove" : {
						"particles_nb" : 2
					}
				}
			},
			"retina_detect" : true
		});
	</script>
</body>
>>>>>>> ee61d503e6b3e08da756937c30fc01d282638335
</html>