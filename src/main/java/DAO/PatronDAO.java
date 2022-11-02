package DAO;

import Model.Paciente;

public interface PatronDAO<T> {
    void darAltaPaciente(T t);
    T buscar(long id);
    void eliminar(long id);
    void modificar(T t);
}
