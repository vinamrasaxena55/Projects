//we will make cart here to interact with amazon
export const cart=[];//now this variable can be used outside this file



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



