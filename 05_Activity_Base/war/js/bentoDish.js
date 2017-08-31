app.controller('dishController', function($scope, $http) {
	console.log("bentoDish.dishController " + "start");

	$scope.$parent.headerName = "Register Dish";
	$scope.$parent.headerImage = "dish_icon.png";
	
	$scope.dishItem = {
			id: 0,
			name: "",
			type: "",
			price: 0
	}
	
    /**
     * Holds the array of dish type that will be used to populate the
     * 'dishItem.type' select element, and contains the image location of the 
     * selected type.
     */
	$scope.typeArray = [
		{optionValue: "mainDish" ,displayValue: "Main Dish", imageFile: "main_dish_type.png"},
		{optionValue: "sideDish" ,displayValue: "Side Dish", imageFile: "side_dish_type.png"},
		{optionValue: "soup" ,displayValue: "Soup", imageFile: "soup_type.png"}
	];
	
	/**
	 * Used to initialize the content of screen 1 ('Register Dish' screen).
	 */
	$scope.initRegisterDishScreen = function(){
		console.log("bentoDish.dishController.initRegisterDishScreen " + "start");
		$scope.dishItem.id = 0;
		$scope.dishItem.name = "";
		$scope.dishItem.type = $scope.typeArray[0];
		$scope.dishItem.price = 0;
		console.log("bentoDish.dishController.initRegisterDishScreen " + "end");
	}
		
	/**
	 * Used to add ingredient to the ingredientList. 
	 */
	$scope.registerDish = function(){
		console.log("bentoDish.dishController.registerDish " + "start");
		// ask the user if he/she wants to proceed to inserting the 'dish'
		var confirmation = window.confirm("Are you sure you want to insert dish?");
		if (true == confirmation) {
			/* creating an object that will contain the information for
				the 'dish' input fields.
			*/
			var dish = {
					/* TODO: Supply the properties of the dish item.
					 * 		 A dish consists of name, type and price.*/
					name: $scope.dishItem.name,
					type: $scope.dishItem.type.optionValue,
					price: $scope.dishItem.price	
			};
			
			// sending the request to the 'RegisterDishController' using AJAX			
			/* TODO: Create an AngularJS AJAX request with 'dish' as the data.
			 * 		 Send it to RegisterDishController.*/
			 $http.post("/RegisterDish",dish);
			
			alert("Please check the console logs in 'eclipse IDE' and the " +
					"local datastore value. Try to refresh datastore if output is " +
					"not seen.");
			// initializing the contents of the ingredient screen.
			$scope.initRegisterDishScreen();
		}
		console.log("bentoDish.dishController.registerDish " + "end");
	}
	
	/** ------------------------------------------------------
	 * Initial Call of the functions.
	 */
	$scope.initRegisterDishScreen();
});
