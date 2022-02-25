import Form from './Form';
import List from './List';
import StoreProvider from './StoreProvider';

function App() {
  return <StoreProvider>
    <h3>To-Do List</h3>
    <Form />
    <List />
  </StoreProvider>
}

export default App;