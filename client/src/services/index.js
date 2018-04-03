import Config from '../config';
import FetchApi from './FetchApi';

const gameService = new FetchApi(Config.api, '/games');
const userService = new FetchApi(Config.api, '/users');

export default {
  gameService,
  userService,
};
