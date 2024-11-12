import axios from 'axios'

const BOND_API_BASE_URL = 'http://172.22.0.22:8080/api/bonds';
class BondService{
    getBonds(){
        return axios.get( BOND_API_BASE_URL );
    }

    getBondItem( Id ){
        return axios.get( BOND_API_BASE_URL + '/' + Id );
    }
}

export default new BondService();