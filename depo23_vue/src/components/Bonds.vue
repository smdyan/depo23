<template>
    <div class = "container"> 
        <h1 class = "text-center"> Bond list </h1>
        <table class = "table table-striped">
            <thead>
                <tr>
                    <th> Id</th>
                    <th> Name</th>
                    <th> MatDate</th>
                </tr>
            </thead>
            <tbody>
                <tr v-for="bondItem in bonds" v-bind:key="bondItem.id">
                    <td> {{bondItem.isin}}</td>
                    <td> {{bondItem.name}}</td>
                    <td> {{bondItem.mat_date}}</td>
                </tr>
            </tbody>
        </table>
    </div>    
</template>

<script>
import BondService from '../services/BondService.js';

export default {
    name: 'Bonds',
    data(){
        return {
            bonds: []
        }
    },
    methods: {
        getBonds(){
            BondService.getBonds().then((response) => {
                this.bonds = response.data._embedded.bondList;   
            });
        }
    },
    created() {
        this.getBonds();
    }
}
</script>
