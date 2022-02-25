import React, { useReducer } from 'react';

const StoreProvider = ({ children }) => {
    const [state, dispatch] = useReducer(reducer, initialState);

    return value={{state, dispatch }}
        {children}
}

export default StoreProvider; 