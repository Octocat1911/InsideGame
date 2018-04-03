export default class {
  constructor(apiUrl, endpoint) {
    this.apiUrl = apiUrl;
    this.endpoint = endpoint;
  }

  async get(id, params = []) {
    const url = new URL(`${this.apiUrl}${this.endpoint}${id ? `/${id}` : ''}`);
    params.forEach(o => Object.keys(o).forEach(key => url.searchParams.append(key, o[key])));
    const res = await fetch(url);
    return res.json();
  }

  async add(resource) {
    const res = fetch(`${this.apiUrl}${this.endpoint}`, {
      method: 'post',
      body: JSON.stringify(resource),
    });
    return res.json();
  }

  async update(id, resource) {
    const res = fetch(`${this.apiUrl}${this.endpoint}/${id}`, {
      method: 'put',
      body: JSON.stringify(resource),
    });
    return res.json();
  }

  async delete(id) {
    const res = fetch(`${this.apiUrl}${this.endpoint}/${id}`, {
      method: 'delete',
    });
    return res.json();
  }
}
