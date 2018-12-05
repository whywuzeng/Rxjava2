cmake_minimum_required(VERSION 3.4.1)

add_library( # Sets the name of the library.
             MyLibrary

             # Sets the library as a shared library.
             SHARED

             # Provides a relative path to your source file(s).
             # Associated headers in the same location as their source
             # file are automatically included.
             src/main/jni/MyLibrary.cpp src/main/jni/FileMuti.cpp )

find_library( # Sets the name of the path variable.
              log-lib

              # Specifies the name of the NDK library that
              # you want CMake to locate.
              log )

# 加入头文件
#target_include_directories(hello-libs PRIVATE
                        #   ${distribution_DIR}/gmath/include
                        #  ${distribution_DIR}/gperf/include)


target_link_libraries( # Specifies the target library.
                      MyLibrary

                       # Links the target library to the log library
                       # included in the NDK.
                       ${log-lib} )
