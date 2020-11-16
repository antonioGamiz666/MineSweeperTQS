package main;

import java.util.Random;

public class Board {

	private int numMines;
	private int maxX;
	private int maxY;
	private Square[][] listSquares;
	
	public Board(int numMines, int maxX, int maxY){
		this.numMines = numMines;
		this.maxX = maxX;
		this.maxY = maxY;
		
		listSquares = new Square[maxX][maxY];
		
		createBoard();
		createMines();
		
	}
	
	public int getNumMines() {return numMines;}
	
	public void setNumMines(int numMines ) {this.numMines = numMines;}
	
	public int getMaxX() {return maxX;}
	
	//public void setMaxX(int maxX) {this.maxX = maxX;}
	
	public int getMaxY() {return maxY;}
	
	//public void setMaxY(int maxY) {this.maxY = maxY;}
	
	
	public void createBoard() {
		
		for(int i=0;i<maxX;i++) {
			for(int j=0;j<maxY;j++) {
				listSquares[i][j] = new Square("number");
			}
		}
	}
	
	
	private int createRandom(int size) {
		Random rand = new Random();
		int random = rand.nextInt(size);
		return random;
		
	}
	
	public void createMines() {
		
		int mines = 0;
		boolean putMine = false;
		
		while (mines<numMines) {
			
			int randX = createRandom(maxX);
			int randY = createRandom(maxY);
			
			if(checkCoordX(randX) && checkCoordY(randY))
			{
				if(listSquares[randX][randY].getTypeObject() == null) {putMine = true;}
				else
				{
					if(listSquares[randX][randY].getTypeObject() == null) {putMine = true;}
					else
					{
						if(listSquares[randX][randY].getTypeObject() == "number") {putMine = true;}
					}					
				}
			}
			
			if(putMine) 
			{
				listSquares[randX][randY].setTypeObject("mine");
				setNumbers(randX, randY);
				mines++;
				putMine = false;
			}
		}	
		
	}
	
	public boolean checkCoordX(int coordX) {return(coordX >= 0 && coordX < maxX);}
	public boolean checkCoordY(int coordY) {return(coordY >= 0 && coordY < maxY);}
	
	private void setNumbers(int X, int Y)
	{
		for(int auxX =X-1; auxX<= X+1; auxX++)
		{
			for(int auxY =Y-1; auxY<= Y+1; auxY++)
			{
				if(checkCoordX(auxX) && checkCoordY(auxY))
				{
					if(listSquares[auxX][auxY].getTypeObject() == null)
					{
						listSquares[auxX][auxY].setNumbers(1);
					}
					else
					{
						if(listSquares[auxX][auxY].getTypeObject() == "number")
						{
							listSquares[auxX][auxY].setNumbers(listSquares[auxX][auxY].getNumber() + 1);
						}
					}
				}
			}
		}
	}
	
	
	/*public void setSquare(Square square, int X, int Y)
	{
		listSquares[X][Y] = square;	
	}*/
	
	public Square getSquare(int X, int Y)
	{
		return listSquares[X][Y];
	}
	
	public String getTypeObject(int X, int Y) {
		
		return listSquares[X][Y].getTypeObject();
	}
	
	public boolean isSelected(int X, int Y) {return listSquares[X][Y].isSelected();}
	
	private void setSelected(int X, int Y, boolean selected) {listSquares[X][Y].setSelected(selected);}
	

	public int getNumber(int x, int y) {return listSquares[x][y].getNumber();}
	
	public int openSquare(int posX, int posY){
        int points = 0;
        if(checkCoordX(posX) && checkCoordY(posY))
        {
            if(!listSquares[posX][posY].isSelected())
            {
                if(getTypeObject(posX, posY) !="mine")
                {
                    setSelected(posX, posY, true);
                    points += 10;
                    
                    if(getNumber(posX, posY)>0){
                        setSelected(posX, posY, true);
                    }else{
                        points += openRecursiveSquare(posX, posY, points);
                    }
                }
                else 
                {
                    setSelected(posX, posY, true);
                    showMineMap();
                    points = 0;
                }            
            }
        }
        else
        {
            points = -1;
        }
        
        return points;
    }

	private int openRecursiveSquare(int posX, int posY, int points){
        
        //System.out.println("posX:" + posX + "  posY:" + posY);
        
        //UP
        if(posY-1>=0){
            points += checkOpenRecursive(posX, posY-1);
        }
        //DOWN
        if(posY+1<getMaxY()){
            points += checkOpenRecursive(posX, posY+1);
        }
        //RIGHT
        if(posX+1<getMaxX()){
            points += checkOpenRecursive(posX+1, posY);
        }
        //LEFT
        if(posX-1>=0){
            points += checkOpenRecursive(posX-1, posY);
        }
        //UP-LEFT
        if(posY-1>=0 && posX-1>=0)
        {
            points += checkOpenRecursive(posX-1, posY-1);
        }
        //UP-RiGHT
        if(posY-1>=0 && posX+1<getMaxX())
        {
            points += checkOpenRecursive(posX+1, posY-1);
        }
        //DOWN-LEFT
        if(posY+1<getMaxY() && posX-1>=0 )
        {
            points += checkOpenRecursive(posX-1, posY+1);
        }
        //DOWN RIGHT
        if(posY+1<getMaxY() && posX+1<getMaxX())
        {
            points += checkOpenRecursive(posX+1, posY+1);
        }
        
        return points;
    }
	
	private int checkOpenRecursive(int X, int Y)
	{
	    int points = 0;
	    if(!listSquares[X][Y].isSelected())
	    {
	        switch (listSquares[X][Y].getTypeObject()) {
	        case "number":
	            points += 10;
	            if(listSquares[X][Y].getNumber()>0)
	            {
	                setSelected(X, Y, true);
	            }
	            else
	            {
	                setSelected(X, Y, true);
	                points += openRecursiveSquare(X, Y, points);
	            }
	            break;
	        case "mine":
	            System.out.println("im a mine, my coord are X:" +  X + " Y:" + Y);
	            break;        
	        default:
	            points += 10;
	            setSelected(X, Y, true);
	            points += openRecursiveSquare(X, Y, points);
	            break;
	        }
	        
	    }
	    return points;
	}
	
	private void showMineMap(){
	    String type;

	    for(int i=0;i<maxX;i++){
	        for(int j=0;j<maxY;j++){
	            type = getTypeObject(i,j);
	            if(type=="mine"){
	            	setSelected(i, j, true);
	            }
	        }
	    }
	}
	
	public void setTypeObject(int X, int Y, String type) {listSquares[X][Y].setTypeObject(type);}
	
	public boolean checkFinish()
	{
		boolean finish = true;
		int i =0,j=0;
		while(i<maxX && finish)
		{
			while(j<maxY && finish)
			{
				if(listSquares[i][j].getNumber() >= 0)
				{
					if(!listSquares[i][j].isSelected())
					{
						finish = false;
					}
				}
				j++;
			}
			i++;
		}
		
		return finish;
	}
	
	public void setFlag(int posX, int posY) {
		if(listSquares[posX][posY].isFlag()) {
			listSquares[posX][posY].setFlag(false);
			if(listSquares[posX][posY].getNumber()==-1) {
				setTypeObject(posX, posY, "mine");
			}else {
				setTypeObject(posX, posY, "number");
			}
		}else {
			listSquares[posX][posY].setFlag(true);
			setTypeObject(posX, posY, "flag");
		}
	}
	
	public boolean getFlag(int posX, int posY) {return listSquares[posX][posY].isFlag();}
	
	//----------------function for test--------------------------------------------------------------//
	/*public void setAllSelecetd()
	{
		for(int x=0; x<maxX; x++)
		{
			for(int y=0; y<maxY; y++)
			{
				listSquares[x][y].setSelected(true);
			}				
		}
	}
	
	public void setNumbertest(int X, int Y) {this.setNumbers(X, Y);}
*/
	//----------------------------------------------------------------------------------------------//
	
}
