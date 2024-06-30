<template>
    <div class = "container"> 
        <h1 class = "text-center"> Bond Item </h1>
        <ul>
            <li v-for="value in relevant" v-bind:key="value">
                {{value}}
            </li>
        </ul>
    </div>    
</template>

<script>
import BondService from '../services/BondService.js';

export default {
    name: 'BondItem',
    data(){
        return {
            bondItem: {}
        }
    },
    computed:{
        relevant(){
            let new_obj = new Object;
            for( let index = 0; index < 10; index++ ){
                new_obj[index] = index;
            }
            return new_obj;
        }
    },
    methods: {
        getBondItem(id){
            BondService.getBondItem(id).then((response) => {
                this.bondItem = response.data;   
            });
        }
    },
    created() {
        this.getBondItem(1);
    }
}
</script>
