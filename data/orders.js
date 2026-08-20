export const orders=JSON.parse(localStorage.getItem('orders'))||[];

export function addOrder(order){
    orders.unshift(order);//unshift add one or more element at start
    saveToStorage();
}

function saveToStorage(){
    localStorage.setItem('orders',JSON.stringify(orders));
}