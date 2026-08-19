class Cart{//when we generate object it will have property of this and method of this class
  cartItems;//adding property to class each object will have this property when added
  #localStorageKey;//if no value iniatalized then it is undefined


  //constructor should not return anything
  //we made localStorageKey private as we dont want others to access it or change it outside code
  constructor(localStorageKey){//run object in constructor and set up object
    //     cart.localStorageKey='cart-oop';
    // buisnesscart.localStorageKey='cart-business';
    // buisnesscart.loadFromStorage();

    // cart.loadFromStorage();
    this.#localStorageKey=localStorageKey;
    this.#loadFromStorage();
  }

   #loadFromStorage  (){//same as  loadFromStorage : function()
  this.cartItems=JSON.parse(localStorage.getItem(this.#localStorageKey));
  //this used to tell object 
 
  //products in products.js
  if(!this.cartItems){
    this.cartItems=  [{
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
}
saveToStorage(){
  localStorage.setItem(this.#localStorageKey,JSON.stringify(this.cartItems));
}

addToCart(productId){
 let matchingItem;
   this.cartItems.forEach((cartItem)=>{
        if(productId===cartItem.productId){
               //if item already in cart
               matchingItem=cartItem;
        }
   });

   if(matchingItem){//boolean type if there true 
           matchingItem.quantity +=1;
   }
   else{
      this.cartItems.push({
    productId : productId,
    quantity:1,
    deliveryOptionId:'1'
   });
   }
   this.saveToStorage();
}
  removeFromCart(productId){
   
let newCart = [];
    
      this.cartItems.forEach((cartItem)=>{
        if(cartItem.productId !==productId){
           newCart.push(cartItem);
        }
      });
      this.cartItems=newCart;//replace the cart
      this.saveToStorage();
}

updateDeliveryOption(productId,deliveryOptionId){
 
  let matchingItem;
    this.cartItems.forEach((cartItem)=>{
          if(productId===cartItem.productId){
              
                matchingItem=cartItem;
          }
    });
 
  matchingItem.deliveryOptionId = deliveryOptionId;

  this.saveToStorage();
}

}

const cart =new Cart('cart-oop');//this will have all properties and methods
const buisnesscart=new Cart('cart-business');


console.log(cart);
console.log(buisnesscart);
//console output
//Cart {cartItems: Array(2), localStorageKey: 'cart-oop'}
// cartItems
// : 
// (2) [{…}, {…}]
// localStorageKey
// : 
// "cart-oop"
// [[Prototype]]
// : 
// Object
// cart-class.js:88 
// Cart {cartItems: Array(2), localStorageKey: 'cart-business'}
// cartItems
// : 
// (2) [{…}, {…}]
// localStorageKey
// : 
// "cart-business"
// [[Prototype]]
// : 
// Object

console.log(buisnesscart instanceof Cart);//true