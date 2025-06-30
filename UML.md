+-------------------------------------------------------+
|            Vehicle                                    |
+-------------------------------------------------------+
| - VehicleID:int                                       |
| - CurrentPosition:DSAGraphVertex                      |
| - Dest: DSAGraphVertex                                |
| - Dist_To_Dest: Object                                |
| - Battery_Level: double                               |
+-------------------------------------------------------+
| + setVehicleID(int ID): void                          |
| + setLocation(DSAGraphVertex Location): void          |
| + setDestination(DSAGraphVertex destination): void    |
| + setDistanceToDestination(Object Distance): void     |
| + setBatteryLevel(double Level): void                 |
| + getLocation(): DSAGraphVertex                       |
| + getDestination(): DSAGraphVertex                    |
| + getDistanceToDestination(): Object                  |
| + getBatteryLevel(): Double                           |
| + getVehicleID(): int                                 |
+-------------------------------------------------------+

+------------------------------------------------------------------------------+
|            DSAGraph                                                          |
+------------------------------------------------------------------------------+
| - Vertices: DSALinkedList                                                    |
| - Edges: DSALinkedList                                                       |
| - NumOfEdge: int                                                             |
+------------------------------------------------------------------------------+
| + addVertex(String Label): void                                              |
| + sortVertex(): void                                                         |
| + addEdge(String L1, String L2, String EdgeLabel, double Distance): void     |
| - getEdge(String Label): DSAGraphEdge                                        |
| - getVertex(String Label): DSAGraphVertex                                    |
| - hasVertex(String Label): boolean                                           |
| + getVertexCount(): int                                                      |
| + getEdgeCount(): int                                                        |
| + isAdjacent(String L1, String L2): boolean                                  |
| + displayAsList(): void                                                      |
| + DisplayNeighbor(String Label): void                                        |
| + displayEdgeList(): void                                                    |
| + displayVertexList(): void                                                  |
| - is_pathBFS(String Label1, String Label2): boolean                          |
| + is_path(String Label1, String Label2): boolean                             |
| - NumOfPath(String L1, String L2): int                                       |
| - dfsCountPaths(DSAGraphVertex current, DSAGraphVertex Dest):int             |
| - getUnvisitedNeighbor(DSAGraphVertex V): DSAGraphVertex                     |
| + getDistance(String L1, String L2): double                                  |
| - findPaths(DSAGraphVertex currentVertex, DSAGraphVertex destVertex          |
|    , double currentDistance, DSAHeap heapArray, String path) : void          |
| - getEdgeLabel(String L1,String L2): String                                  |
| + displayGraphStructure(): void                                              |
+------------------------------------------------------------------------------+

+------------------------------------------------------------------------------+
|            DSAGraphEdge                                                      |
+------------------------------------------------------------------------------+
| - From: DSAGraphVertex                                                       |
| - To: DSAGraphVertex                                                         |
| - Label: String                                                              |
| - Value: double                                                              |
+------------------------------------------------------------------------------+
| + getLabel():String                                                          |
| + getValue(): double                                                         |
| + getTo(): DSAGraphVertex                                                    |
| + getFrom(): DSAGraphVertex                                                  |
+------------------------------------------------------------------------------+

+------------------------------------------------------------------------------+
|            DSAGraphVertex                                                    |
+------------------------------------------------------------------------------+
| - Label: String                                                              |
| - Value: String                                                              |
| - Neighbor: DSALinkedList                                                    |
| - Visited: boolean                                                           |
+------------------------------------------------------------------------------+
| + isVisited(): boolean                                                       |
| + setVisited(boolean Visited): void                                          |
| + clearVisited(): void                                                       |
| + getLabel(): String                                                         |
| + getNeighbors(): DSALinkedList                                              |
| + addNeighbors(DSAGraphVertex NeighborVertex): void                          |
| + deleteNeighbors(DSAGraphVertex NeighborVertex): void                       |
| + hasNeighbors(DSAGraphVertex Targetneighbor): boolean                       |
| + DisplayNeighbor(): void                                                    |
| + sortNeighbor(): void                                                       |
+------------------------------------------------------------------------------+

+------------------------------------------------------------------------------+
|            DSAHashEntry                                                      |
+------------------------------------------------------------------------------+
| - Key: String                                                                |
| - Value: Object                                                              |
| - State: int                                                                 |
+------------------------------------------------------------------------------+
| + getKey(): String                                                           |
| + getValue(): Object                                                         |
| + setKey(String newKey): void                                                |
| + setValue(Object newValue): void                                            |
| + getState(): int                                                            |
| + setState(int newState): void                                               |
+------------------------------------------------------------------------------+

+------------------------------------------------------------------------------+
|            DSAHashTable                                                      |
+------------------------------------------------------------------------------+
| - hashArray: DSAHashEntry []                                                 |
| - Count: int                                                                 |
| - Size: int                                                                  |
+------------------------------------------------------------------------------+
| - CountNumVehicle(String source, String dest): int                           |
| + find_Vehicle_With_HighestBattery(String source, String dest): double       |
| + recommenVehicle(String Source, String Dest): Vehicle                       |
| + hash(String Key): int                                                      |
| - findNextPrime(int StartVal): int                                           |
| + hasKey(String inKey): boolean                                              |
| + put(String inKey, Object inValue): void                                    |
| + get(String inKey): Object                                                  |
| + findKey(String inKey): int                                                 |
| + remove(String inKey): Object                                               |
| - resize(int currentSize): void                                              |
| - getLoadFactor(): double                                                    |
| + DisplayHashTable(): void                                                   |
| + DisplayKeyValue(String inKey): void                                        |
+------------------------------------------------------------------------------+

+----------------------------------------------+
|            DSAHeap                           |
+----------------------------------------------+
| - heap: DSAHeapEntry[]                       |
| - Count: int                                 |
+----------------------------------------------+
| + heapify(): void                            |
| + findshortestDistance(): double             |
| + heapSort(): void                           |
| + add(double priority, Object Value): void   |
| + TrickleUp(int currentIndex): void          |
| + TrickeDown(int currentIndex): void         |
| + Display(): void                            |
+----------------------------------------------+


+---------------------------------------+
|             DSAHeapEntry              |
+---------------------------------------+
| - priority: double                    |
| - Value: Object                       |
+---------------------------------------+
| + getPriority(): double               |
| + setPriority(double newPriority):void|
| + getValue(): Object                  |
| + setValue(Object newValue): void     |
+---------------------------------------+

+---------------------------------------+
|             DSAQuickSort              |
+---------------------------------------+
| + QuickSort(double [] Arr,            |
|   int low, int high): void            |
| + partition(double [] Arr,            |
|   int low, int high):void             |
| + partition(double [] Arr,            |
|    int low, int high)                 |
+---------------------------------------+

