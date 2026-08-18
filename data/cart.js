//we will make cart here to interact with amazon
export let cart;

loadFromStorage();


 
export function loadFromStorage(){
  cart=JSON.parse(localStorage.getItem('cart'));
//converting from string back to array
//we are just saving id, which we can use to search 
  //products in products.js
  if(!cart){//if cart empty put some default values
    cart=  [{
   productId: 'e43638ce-6aa0-4b85-b27f-e1d07eb678c6',
   quantity: 2,
   deliveryOptionId:'1'
},
{
  productId: '15b6fc6f-327a-4ec4-896f-486349e85a3d',
   quantity: 1,//giving some default values
   deliveryOptionId:'2'//from deliveryOptions 
}
  ];
  }

//now this variable can be used outside this file
}


function saveToStorage(){
  localStorage.setItem('cart',JSON.stringify(cart));
  //remember local storage can only store strings
}



export function addToCart(productId){
 let matchingItem;
   cart.forEach((cartItem)=>{
        if(productId===cartItem.productId){
               //if item already in cart
               matchingItem=cartItem;
        }
   });

   if(matchingItem){//boolean type if there true 
           matchingItem.quantity +=1;
   }
   else{
      cart.push({
    productId : productId,
    quantity:1,
    deliveryOptionId:'1'
   });
   }
   saveToStorage();//whenever saved store in local storage
}

export function removeFromCart(productId){
   
let newCart = [];
      //create new array
      //loop through cart
      //add each product to new array, except for this productid  
      cart.forEach((cartItem)=>{
        if(cartItem.productId !==productId){
           newCart.push(cartItem);
        }
      });
      cart=newCart;//replace the cart
      saveToStorage();
}


export function updateDeliveryOption(productId,deliveryOptionId){
 //loop through cart and find product
 //update delivery optionId of product

  let matchingItem;
    cart.forEach((cartItem)=>{
          if(productId===cartItem.productId){
                //if item already in cart
                matchingItem=cartItem;
          }
    });
  //updating delivery id 
  matchingItem.deliveryOptionId = deliveryOptionId;

  saveToStorage();
}
