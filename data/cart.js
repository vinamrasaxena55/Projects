//we will make cart here to interact with amazon
export const cart=[{//we are just saving id, which we can use to search 
  //products in products.js
   productId: 'e43638ce-6aa0-4b85-b27f-e1d07eb678c6',
   quantity: 2
},
{
  productId: '15b6fc6f-327a-4ec4-896f-486349e85a3d',
   quantity: 1//giving some default values
}

];//now this variable can be used outside this file



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
    quantity:1
   });
   }
}

export function removeFromCart(productId){
      //create new array
      //loop through cart
      //add each product to new array, except for this productid  
      cart.forEach((cartItem)=>{
        if(cartItem.productId !==productId){
           newCart.push(cartItem);
        }
      });
      cart=newCart;//replace the cart
}

