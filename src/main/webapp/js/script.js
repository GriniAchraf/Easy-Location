var app = angular.module("app", []);
app.controller("AppController", function($scope,$http) {
  
  $scope.barMenu=[{title:"accueil",state:false},{title:"Mes opérations",state:false},{title:"Mon panier",state:false},{title:"Mes infos",state:true}];
  $scope.categories=[
  {principal:"Tous" ,state:true ,scateg: [] },
                        {principal:"VEHICULES" ,state:false ,scateg: ["Utilitaires","Remoque","Accessoires Auto","Moto et scooter","Voiture de luxe"] },
{principal:"BRICO" ,state:false ,scateg: ["Outils","Matériel rénovation","Jardinage","Matériel entretien"] },
{principal:"EVENEMENT" ,state:false ,scateg: ["Location mobilier","Location réception","Cuisine","Animation"] },
{principal:"HIGH TECH " ,state:false ,scateg: ["Photo","Informatique","Matériel video","Matériel audio"] },
{principal:"LOISIRS" ,state:false ,scateg: ["Sport individuel","Sport de glisse","Vélo","Montagne"] },
{principal:"LUXE" ,state:false ,scateg: ["Voiture de luxe","Robe de soirée","Costume ","Accessoires "] },
{principal:"MAISON" ,state:false ,scateg: ["Electroménager","Matériel médical","Mobilier d'intérieur "] },
{principal:"VACANCES" ,state:false ,scateg: ["Camping-Car","Camping","Villa ","Appartement "] }

  ];

  $scope.objets=[

{titre:"Ponceuse",pj:30,img:"img/objets/Ponceuse/1.jpg",scateg:"Moto et scooter",pl:"Paris 17"},
{titre:"Yamaha fzs600 fazer",pj:40,img:"img/objets/Yamaha fzs600 fazer/1.jpg",scateg:"Matériel rénovation",pl:"Paris 5"}


  ];
  $scope.pointsLocation=[{name:"Paris 17",isCheked:false}, {name:"Paris 16",isCheked:false},{name:"Paris 13",isCheked:false},{name:"Paris 5",isCheked:false} ];

$scope.objetsA=$scope.objets;
$scope.objetsSL=$scope.objets;
function getObjetsBySCat(scat){
    result=[];
    for(i=0;i<$scope.objetsSL.length;i++){
            if($scope.objetsSL[i].scateg==scat)
            	result.push($scope.objetsSL[i]);
    }
    return result;
}

function getObjetsByCat(cat){
     result=[];

     for(j=0;j<cat.scateg.length;j++)
     {  
     	
     	result=result.concat(getObjetsBySCat(cat.scateg[j]));
     }
     return result;
}
function setCatState(indice){
	for(i=0;i<$scope.categories.length;i++)
	{
		if(i==indice)
			$scope.categories[i].state=true;
		else
			$scope.categories[i].state=false;
	}
}

$scope.rechercheByCat=function(indice){
	if(indice==0){
		$scope.objetsA=$scope.objetsSL;
		$scope.searsh="";
	}
	else
	$scope.objetsA=getObjetsByCat($scope.categories[indice]);


	setCatState(indice);
$scope.scSelected=-1;


}

$scope.scSelected=-1;
$scope.isTrue=function(sc){
	if(sc==$scope.scSelected)
	return true;
   else return false;
}
$scope.rechercheBySCat=function(indice,indiceSc,scat){
	$scope.scSelected=indiceSc;
	$scope.objetsA=getObjetsBySCat(scat);
	setCatState(indice);
	
}




  $scope.redirectInscription = function() {
console.log("done!!");
		$http({
			url : window.location.href + "inscriptionClient",
			method : "GET",

		}).then(function(response) {
			// console.log(response.data);
			$scope.message = response.data;
		}, function(response) {
			// fail case
			console.log(response);
			$scope.message = response;
		});

	};
	

	function getObjetsByPl(pl){
    result=[];
    for(k=0;k<$scope.objets.length;k++){
            if($scope.objets[k].pl==pl.name)
            	result.push($scope.objets[k]);
    }
    return result;
}
function getObjetsBySPl(){
    result=[];
    for(i=0;i<$scope.pointsLocation.length;i++){
    	     if($scope.pointsLocation[i].isCheked)
    	     {console.log($scope.pointsLocation[i].name);
            result=result.concat(getObjetsByPl($scope.pointsLocation[i]));
        }
    }
    return result;
}

	$scope.getByPL=function(){

		$scope.supprPl=true;
		$scope.objetsA=getObjetsBySPl();
		$scope.objetsSL=$scope.objetsA;
		$scope.rechercheByCat(0);
	}
	$scope.supprPl=false;

$scope.renitPl=function(){
	for(i=0;i<$scope.pointsLocation.length;i++){
    	     $scope.pointsLocation[i].isCheked=false;
            
    }
    $scope.objetsSL=$scope.objets;
    $scope.objetsA=$scope.objetsSL;
    $scope.rechercheByCat(0);
	$scope.supprPl=false;
}
$scope.chercher=function(){
	result=[];
	for(s=0;s<$scope.objetsSL.length;s++)
		if($scope.objetsSL[s].titre.toLowerCase().includes($scope.searsh.toLowerCase()))
			result.push($scope.objetsSL[s]);
		$scope.objetsA=result;
	
}
    


});

app.controller("InfosController", function($scope,$http) {

$scope.barMenu=[{title:"accueil",state:true},{title:"Mes opérations",state:false},{title:"Mon panier",state:false},{title:"Mes infos",state:false}];
$scope.objet={idObjet:"dadazde478",pointLivraison:"Paris 5",prixJrn:40,amendeJrn:5,cautionLocation:2500,categorie:"Moto et scooter",titre:"Yamaha fzs600 fazer",
description:"La moto est en très bon état et sort d'une révision de routine. Fiable, légère et maniable, elle consomme peu (plein ~ 300 km)."};




$scope.reserver=function(){
	
}
});

app.controller("PanierController", function($scope,$http) {
$scope.barMenu=[{title:"accueil",state:false},{title:"Mes opérations",state:false},{title:"Mon panier",state:true},{title:"Mes infos",state:false}];

$scope.favoris=[{idObjet:"dadazde478",pointLivraison:"Paris 17",prixJrn:30,amendeJrn:5,cautionLocation:300,categorie:"Moto et scooter",titre:"Ponceuse",
description:"La moto est en très bon état et sort d'une révision de routine. Fiable, légère et maniable, elle consomme peu (plein ~ 300 km).",isCheked:false,dureeLocation:3},
{idObjet:"dadazde478",pointLivraison:"Paris 5",prixJrn:40,amendeJrn:5,cautionLocation:2500,categorie:"Moto et scooter",titre:"Yamaha fzs600 fazer",
description:"La moto est en très bon état et sort d'une révision de routine. Fiable, légère et maniable, elle consomme peu (plein ~ 300 km).",isCheked:false,dureeLocation:3}];

$scope.sl={dureeMinLocation:3,dureeMaxLocation:10,dureeMaxRsrv:5};
$scope.tab=[];
$scope.dureeLocation=$scope.sl.dureeMinLocation;
for(i=0;i<=$scope.sl.dureeMaxLocation-$scope.sl.dureeMinLocation;i++)
	$scope.tab[i]=i+$scope.sl.dureeMinLocation;

$scope.calculTotal=function(){
	var resultat=0;
	for(j=0;j<$scope.favoris.length;j++)
		if($scope.favoris[j].isCheked)
			
		resultat+=$scope.favoris[j].dureeLocation * $scope.favoris[j].prixJrn;
		
		return resultat;
}




	});

app.controller("InsciptionController", function($scope,$http,$window) {

$scope.barMenu=[{title:"accueil",state:false},{title:"Mes opérations",state:false},{title:"Mon panier",state:false},{title:"Mes infos",state:false}];

$scope.client={};
 $scope.createClient = function() 
  {
    $http({
      method: 'POST',
      url: window.location.href.substring(0,36)+'addClient',
      headers: {'Content-Type': 'application/json'},
      data:  $scope.client
    }).success(function (data) 
      {
      	if(data=="Ce login existe deja")
    	$scope.status=data;
    	else
//////////////////////////
$window.location.href = window.location.href.substring(0,36)+'addClient';
/////////////////////////




      });
  };


	});

app.controller("AdminController", function($scope,$http) {
	$scope.sl={};
	$scope.msg="";
	$scope.sauvegarder=function(){

	}
	$scope.deconexion=function(){

	}

	});

app.controller("LoginAdminController", function($scope,$http) {
$scope.msg="";
	$scope.user={};

	$http({
      method: 'GET',
      url: window.location.href.substring(0,36)+'parametrage'
    }).success(function (data) 
      {
      	




      });

	$scope.connexion=function(){


$http({
      method: 'POST',
      url: window.location.href.substring(0,36)+'easyLocation/admin/login',
      headers: {'Content-Type': 'application/json'},
      data:  $scope.user
    }).success(function (data) 
      {
      	




      });
	}

	});