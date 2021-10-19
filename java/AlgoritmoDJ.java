import java.io.*;
/**
 * @author: Ing. Noé Vásquez Godínez
 * @email: noe-vg@outlook.com
 * @about: Clase para implementar Dijkstra's algorithm
 */
class AlgoritmoDJ{
    /**
     * @about:
     * En este metodo se iniciara sel setup del algoritmo
     */
    public void init() throws IOException{
        this.start();
        int matrizGrafo [][];
        int ultimovertice [];//Guarda desde el origen al destino el ultimo vertice
        int datosVertice [];
        boolean caminos [];//Vertices visitados
        int origen, numOriGrafo [];//El punto de origen y en donde de se encuentra

        this.origen = origen;
        ultimovertice = new int[numOriGrafo];
        datosVertice = new int[numOriGrafo];
        caminos = new boolean[numOriGrafo];
        
        //Valores iniciales 
        for(int i=0; i<numOriGrafo; i++){
            caminos[i] = false; //Se inicializan los vertices como no visitados
            datosVertice = matrizGrafo [origen][numOriGrafo]; //
            ultimovertice[i] = origen;
        }
        caminos[origen] = true;
        datosVertice[origen] = 0;

        for (int i=0; i<numOriGrafo; i++){
            int v = minimo();// Este selecciona el vertice no marcado de menor distancia
            
            caminos[v] = true;
            for(int w=0; w<numOriGrafo; w++){//Actualiza del vertice no marcado
                if(!caminos[w]){
                    if((datosVertice[v] + matrizGrafo[v][w]) < datosVertice[w]){
                        datosVertice[w] = datosVertice[v] + matrizGrafo[v][w];
                        ultimovertice[w] = v;
                    }
                }
            }
        }
    }

    public int minimo(){
        int maximo = grafo.inf;
        int v = 1;
        for(int j=0; j<numOriGrafo; j++){
            if(!caminos[j] && (datosVertice[j] <= maximo)){
                maximo = datosVertice[j];
                v = j;
            }
        }
        return v;
    }
    /**@about: 
     * En este metodo se incia el algoritmo
     */
    private void start(){
        System.out.println("[OK] starting . . .");
        
        Gui guiInterface = new Gui();
        guiInterface.setVisible(true);
    
    } 
    public static void main(String[] args) throws IOException {
        BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
        AlgoritmoDJ algoritmoDJ = new AlgoritmoDJ();
        algoritmoDJ.init();

        
        int resp, ruta;
        String temp []=leer.readLine().split(" ");
        int vertices = Integer.parseInt(temp[0]);
        int aristas = Integer.parseInt(temp[1]);
        System.out.println("Ingrese el vertice origen: ");
        resp = Integer.parseInt(leer.readLine());
        System.out.println("Seleccione la ruta a llegar: ");
        ruta = Integer.parseInt(leer.readLine());

        for (int i = 0; i < vertices; i++) {
            String temp2 [] =leer.readLine().split(" ");
            insMatriz(Integer.parseInt(temp2[0]), Integer.parseInt(temp2[1]), Integer.parseInt(temp2[2]));
        }
    }
}