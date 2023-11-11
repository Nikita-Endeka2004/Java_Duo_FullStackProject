package userRegistration.persistence.api;

import java.util.Collection;

public interface CRUD <T> {

    public T create(T ent);
    public Collection<T> create(Collection<T> ents);
    public T read(int id);
    public void update(T ent);
    public void update(Collection<T> ents);
    public void delete(T ent);

}
