package dao.impl;

import org.springframework.stereotype.Repository;

/**
 * 运用jdbc方式进行查询
 */
@Repository
//public class JDBCBookDaoImpl  implements BookDao {
public class JDBCBookDaoImpl  {
   /* @Override
    public List<Book> queryAll() {
        Connection connection = DB.getConnection();
        String sql = "SELECT * FROM db.book ORDER BY id DESC";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Book> books = new LinkedList<>();
            while (resultSet.next()) {
                Book book = new Book(
                        resultSet.getInt("id"),
                        resultSet.getString("title"),
                        resultSet.getDouble("price"),
                        resultSet.getInt("amount"),
                        resultSet.getString("pubTime")
                );
                books.add(book);
            }
            DB.close(resultSet, preparedStatement, connection);
            return books;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Book queryById(int id) {
        return null;
    }

    @Override
    public void removeSelected(int[] ids) {

    }

    @Override
    public void create(Book book) {

    }

    @Override
    public void update(Book book) {

    }

    @Override
    public void remove(int id) {

    }

    @Override
    public void removeBooks(int[] ids) {

    }*/
}
