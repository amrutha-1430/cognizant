import axios from 'axios';
import GitClient from './GitClient';

jest.mock('axios');

describe('Git Client Tests', () => {
  test('should return repository names for techiesyed', async () => {
    const mockData = {
      data: [
        { name: 'appcentricsolutions' },
        { name: 'ArrayListDemo' },
        { name: 'ArrayListDemo01' }
      ]
    };

    axios.get.mockResolvedValue(mockData);

    const response = await GitClient.getRepositories('techiesyed');
    expect(response.data).toEqual(mockData.data);
    expect(axios.get).toHaveBeenCalledWith('https://api.github.com/users/techiesyed/repos');
  });
});
