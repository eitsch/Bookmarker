package database;

import java.sql.SQLException;

@FunctionalInterface
public interface DatabaseSelectFunction<S, T, R> {
    /**
     * FunctionalInterface -> Lambda, Methodenreferenz
     *
     * @param s Function Argument
     * @param t Function Argument
     * @return Result
     * @throws SQLException
     */
    R execute(S s, T t) throws SQLException;
}