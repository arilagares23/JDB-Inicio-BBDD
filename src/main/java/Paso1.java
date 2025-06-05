import java.sql.*;

public class Paso1 {
    public static void main(String[] args){
        //Definimos los parametros de conexion a la BBDD
        String url= "jdbc:postgresql://127.0.0.1:5432/jardineria";
        String user= "paisajista";
        String clave= "43135650Ari";
        // Creamos la instancia de la conexion a la BBDD
        try{
            //Creamos la instancia de la conexion a la BBDD
            Connection conex = DriverManager.getConnection(url,user,clave);
            //Creamos una instancia de sentencia para poder enviar consultas al servidor BBDD
            Statement st = conex.createStatement();
            //Definios la consulta, la enviamos al servidor (ejecutamos la sentecia) y obtenemos el resultado
            ResultSet rs = st.executeQuery(conex.nativeSQL("SELECT * FROM cliente"));

            //En el ResultSet tenemos todos los registros devueltos por el servidor ddentro de un iterador
            while (rs.next()) {
                System.out.println(rs.getInt(1) + " " + rs.getString(2));
            }
            rs.close();
            st.close();
            conex.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            //Al utilizar finally nos aseguramos que los recursos se cierran aunque el try falle
            //rs.close();
            //st.close();
            //conex.close();
        }

    }
}
