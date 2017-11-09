

<div class="row">

	<div class="col s3">
		<header>
			<div class="container"><a href="#" data-activates="nav-mobile" class="button-collapse top-nav full hide-on-large-only"><i class="material-icons">menu</i></a></div>
			<ul id="nav-mobile" class="side-nav fixed">
                <li>
                    <img class="circle responsive-img img-profil" src="men.jpg">
                </li>

				<li class="no-padding">
					<ul class="collapsible collapsible-accordion">
						<li class="bold"><a class="collapsible-header  waves-effect waves-teal">Dashboard</a></li>
                        <li class="bold"><a class="collapsible-header  waves-effect waves-teal">Users</a></li>
                        <li class="bold"><a class="collapsible-header  waves-effect waves-teal">Rooms</a></li>
                        
		</header>



	</div>

	<div class="col s9">


		<div class="container">

            <h1> Dashboard </h1>

			
<h1>Index</h1>
${model}
<br />
<ul>
	<c:forEach items="${model}" var="prenom">
		<li>${prenom}</li>
	</c:forEach>
</ul>

		</div>
	</div>


</div>


<script type="text/javascript" src="http://code.jquery.com/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="js/materialize.min.js"></script>
<script>
    $( document ).ready(function(){
        $(".button-collapse").sideNav();
    });
</script>



